package com.kc.gobang.game;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.gobang.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

@Component
public class Matcher {
    private Queue<User> normalQueue = new LinkedList<User>();
    private Queue<User> highQueue = new LinkedList<User>();
    private Queue<User> veryHighQueue = new LinkedList<User>();
    @Autowired
    private OnlineUserManager onlineUserManager;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RoomManager roomManager;
    public void add(User user) {
        if (user.getScore() < 2000) {
            synchronized (normalQueue) {
                normalQueue.offer(user);
                normalQueue.notify();
            }
            System.out.println("把玩家加入" + user.getUsername() + "normalQueue");
        } else if (user.getScore() < 3000) {
            synchronized (highQueue) {
                highQueue.offer(user);
                highQueue.notify();
            }
            System.out.println("把玩家加入" + user.getUsername() + "highQueue");
        } else {
            synchronized (veryHighQueue) {
                veryHighQueue.offer(user);
                veryHighQueue.notify();
            }
            System.out.println("把玩家加入" + user.getUsername() + "veryHighQueue");
        }
    }

    public void remove(User user) {
        if (user.getScore() < 2000) {
            synchronized (normalQueue) {
                normalQueue.remove(user);
            }
            System.out.println("把玩家移除" + user.getUsername() + "normalQueue");
        } else if (user.getScore() < 3000) {
            synchronized (highQueue) {
                highQueue.remove(user);
            }
            System.out.println("把玩家移除" + user.getUsername() + "highQueue");
        } else {
            synchronized (veryHighQueue) {
                veryHighQueue.remove(user);
            }
            System.out.println("把玩家移除" + user.getUsername() + "veryHighQueue");
        }
    }

    public Matcher() {
        Thread t1 = new Thread(() -> {
            while (true) {
                handleMatch(normalQueue);
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            while (true) {
                handleMatch(highQueue);
            }
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            while (true) {
                handleMatch(veryHighQueue);
            }
        });
        t3.start();
    }

    private void handleMatch(Queue<User> queue) {
        synchronized (queue) {
            try {
                while (queue.size() < 2) {
                    queue.wait();
                    return;
                }
                User user1 = queue.poll();
                User user2 = queue.poll();
                //获取回话
                WebSocketSession session1 = onlineUserManager.getSessionFromGameHall(user1.getUserId());
                WebSocketSession session2 = onlineUserManager.getSessionFromGameHall(user2.getUserId());
                if (session1 == null) {
                    queue.offer(user2);
                    return;
                }
                if (session2 == null) {
                    queue.offer(user1);
                    return;
                }
                if (session2 == session1) {
                    queue.offer(user2);
                    return;
                }
                //放入游戏房间
                Room room = new Room();
                roomManager.addRoom(room,user1.getUserId(), user2.getUserId());
                //返回响应数据
                MatchResponse matchResponse1 = new MatchResponse();
                matchResponse1.setOk(true);
                matchResponse1.setMessage("matchSuccess");
                String s1 = objectMapper.writeValueAsString(matchResponse1);
                session1.sendMessage(new TextMessage(s1));
                MatchResponse matchResponse2 = new MatchResponse();
                matchResponse2.setOk(true);
                matchResponse2.setMessage("matchSuccess");
                String s2 = objectMapper.writeValueAsString(matchResponse2);
                session1.sendMessage(new TextMessage(s2));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
