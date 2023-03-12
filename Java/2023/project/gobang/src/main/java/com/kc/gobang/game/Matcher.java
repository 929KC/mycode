package com.kc.gobang.game;


import com.kc.gobang.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class Matcher {
    private Queue<User> normalQueue = new LinkedList<User>();
    private Queue<User> highQueue = new LinkedList<User>();
    private Queue<User> veryHighQueue = new LinkedList<User>();
    @Autowired
    private OnlineUserManager onlineUserManager;

    public void add(User user) {
        if (user.getScore() < 2000) {
            normalQueue.offer(user);
            System.out.println("把玩家加入" + user.getUsername() + "normalQueue");
        } else if (user.getScore() >= 2000 && user.getScore() < 3000) {
            highQueue.offer(user);
            System.out.println("把玩家加入" + user.getUsername() + "highQueue");
        } else {
            veryHighQueue.offer(user);
            System.out.println("把玩家加入" + user.getUsername() + "veryHighQueue");
        }
    }

    public void remove(User user) {
        if (user.getScore() < 2000) {
            normalQueue.remove(user);
        } else if (user.getScore() >= 2000 && user.getScore() < 3000) {
            highQueue.remove(user);
        } else {
            veryHighQueue.remove(user);
        }
    }

}
