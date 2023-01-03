package com.bit.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 */
public class MinStack {
    private Deque<Integer> dataStack;
    private Deque<Integer> minStack;

    public MinStack() {
        dataStack=new LinkedList<Integer>();
        minStack=new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
      // minStack.push(0);
    }

    public void push(int val) {
        dataStack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return   minStack.peek();
    }
}