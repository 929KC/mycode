package com.bit.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 两个队列模拟栈
 */
class MyStack {
    private Deque<Integer> qu1;
    private Deque<Integer> qu2;
    private int userSized;

    public MyStack() {
        qu1 = new LinkedList<Integer>();
        qu2 = new LinkedList<Integer>();
    }

    //入栈
    public void push(int x) {
        if (!qu1.isEmpty()) {
            qu1.offer(x);
        } else if (!qu1.isEmpty()) {
            qu2.offer(x);
        } else {
            qu1.offer(x);
        }
    }
    //出栈
    public int pop() {
        if(empty()){
            return -1;
        }

       if(!qu1.isEmpty()){
           int curSize=qu1.size();
           for(int i=0;i<curSize-1;i++){
               qu2.offer(qu1.poll());
           }
           userSized--;
           return qu1.poll();
       }else {
           int curSize=qu2.size();
           for(int i=0;i<curSize-1;i++){
               qu1.offer(qu2.poll());
           }
           userSized--;
           return qu2.poll();
       }

    }
    //peek
    public int top() {
        if(empty()){
            return -1;
        }

        if(!qu1.isEmpty()){
            int curSize=qu1.size();
            int ret=-1;
            for(int i=0;i<curSize;i++){
                ret=qu1.poll();
                qu2.offer(ret);
            }
            userSized--;
            return ret;
        }else {
            int curSize=qu2.size();
            int ret=-1;
            for(int i=0;i<curSize;i++){
                ret=qu2.poll();
                qu1.offer(ret);
            }
            userSized--;
            return ret;
        }

    }

    public boolean empty() {
        //return userSized==0;
        return qu1.isEmpty() && qu2.isEmpty();
    }
}

