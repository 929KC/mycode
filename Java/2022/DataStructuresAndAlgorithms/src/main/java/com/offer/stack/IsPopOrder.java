package com.offer.stack;

import java.util.Stack;

public class IsPopOrder {
    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[]  pushed, int[] popped) {
        // if (pushed==null||popped==null||pushed.length==0||popped.length==0) {
        //     return false;
        // }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num:pushed) {
            stack.push(num);
            while (!stack.isEmpty()&&stack.peek()==popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
