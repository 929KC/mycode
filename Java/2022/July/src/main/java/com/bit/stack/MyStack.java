package com.bit.stack;


import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-09 21:01
 */

public class MyStack {
    int [] el;
    int userSized;
    static final int  DEFAULT_CAPACITY =10;

    public MyStack(){
        el=new int[DEFAULT_CAPACITY];
    }

    private boolean isFull(){
      return this.userSized==el.length;
    }

    public int push(int val){
        if(isFull()){
            el= Arrays.copyOf(el,el.length*2);
        }
      return  el[userSized++]=val;
    }

    private boolean isEmpty(){
        return  userSized==0;
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }
       int ret= peek();
       userSized--;
       return ret;
    }

    public int peek(){
    return el[userSized-1];
    }

    public int size(){
        return  userSized;
    }

    public void traverse(){
      for(int i=userSized-1;i>=0;i--){
          System.out.print(el[i]+" ");
      }
    }
}
