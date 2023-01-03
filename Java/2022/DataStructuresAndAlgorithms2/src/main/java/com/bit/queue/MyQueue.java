package com.bit.queue;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
       s1.push(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }

        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }

        if(s2.isEmpty()){
            while(s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty()&&s2.isEmpty();
    }
}

