package com.bit.queue;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-10 12:32
 */

/**
 * 使用数组模拟环形队列
 */
public class CircleArrayQueue {
    public int[] elem;
    public int front;
    public int rear;

    public CircleArrayQueue(int maxSize){
        elem=new int[maxSize];
    }

    //入队
    public boolean enQueue(int value) {
       if(isFull()){
           return false;
       }
       elem[rear]=value;
       rear=(rear+1)%elem.length;
       return true;
    }
    //出队
    public boolean  deQueue() {
        if(isEmpty()){
         return false;
        }
        front=(front+1)%elem.length;
        return true;
    }

    //获取队头元素
    public int Front() {
        if(isEmpty()){
            throw new RuntimeException("队列为空,没有元素可以出队");
        }
        return elem[front];
    }

    //获取队尾元素
    public int Rear() {
        if(isEmpty()){
            throw new RuntimeException("队列为空,没有元素可以出队");
        }
        int index=rear==0?elem.length-1 : rear-1;
        return elem[index];
    }

    public boolean isEmpty() {
        return front==rear;
    }

    public boolean isFull() {
        return (rear+1)% elem.length == front;
    }

    /**
     * 队列中的有效个数
     * @return
     */
    public int size() {
        return (rear+ elem.length-front)%elem.length;
    }

    /**
     * 遍历队列
     */
    public void traverse(){
        for(int i=0;i<front+size();i++){
            System.out.print(elem[i]+" ");
        }
    }
}
