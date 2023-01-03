package com.bit.queue;


/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-09 21:44
 */

/**
 * 使用数组实现普通队列
 */
public class ArrayQueue {
    public static final int  DEFAULT_CAPACITY=5;
    private int font ;
    private  int rear ;
    private int []  el;

    public ArrayQueue(){
        el=new int[DEFAULT_CAPACITY];
        font=-1;
        rear=-1;
    }

    public boolean  offer(int val){
        if(isFull()){
            throw new RuntimeException("队列已满,不能添加元素");
        }else{
            rear++;
            el[rear]=val;
            return true;
        }
    }

    public Object poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空,无法取出数据");
        }
        return el[++font];
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("队列为空,无法获取元素");
        }
        return el[font+1];
    }

    public int size(){
        return (rear+1);
    }

   public boolean isEmpty(){
        return font==rear;
    }

    public boolean isFull(){
        return rear==DEFAULT_CAPACITY-1;
    }

    public void traverse(){
        for(int i=font+1;i<=rear;i++){
            System.out.print(el[i]+" ");
        }
    }
}
