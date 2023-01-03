package com.bit.arraylist;

import java.util.Arrays;

public class MyList {
    private  static final int  capacity = 3;//初始化数组的容量
    private   int elem[];
    private int userSized;//记录顺序表中元素的个数

    public MyList() {
        this.elem = new int [capacity];
        this.userSized = 0;
    }


        /**
         * 打印顺序表中的数据
         */
        public void display(){
        for(int i=0;i<this.userSized;i++){
        System.out.print(this.elem[i]+" ");
        }
            System.out.println();}
        //判断顺序变中是否存满元素
    private boolean isFull(){
        if(this.elem.length==this.userSized){
            return true;
        }
        return false;
    }
        //向顺序表中添加数据
        public void add(int pos ,int data){
            //checkPos(pos);
            if(isFull()){
              this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
           }

            if(pos<0||pos>this.userSized){
              return;
            }
            for(int i=userSized-1;i>=pos;i--){
                this.elem[i+1]=this.elem[i];
            }
           this.elem[pos]=data;
            this.userSized++;
    }
    //判断是否包含某个元素
    public boolean contains(int toFind){
        for(int i=0;i<this.elem.length;i++){
            if(elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    //查找某一个元素的对应的位置
    public int search(int toFind){
        for(int i=0;i<this.elem.length;i++){
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取顺序表长度
    public int size() {
        return this.userSized;
        }
        //判断顺序表是否为空
    public boolean isEmpty() {
            if(this.userSized==0){
                return true;
            }
            return false; }
        // 获取 pos 位置的元素
    public int getPos(int pos) {
            if(isEmpty()){
              throw  new RuntimeException("顺序表为空");
            }
        if(pos<0||pos>=this.userSized){
            throw new RuntimeException("pos不合法");
        }
        return this.elem[pos];
    }

   /* private void checkPos(int pos) {
        if(pos<0||pos>this.userSized){
            throw new RuntimeException("pos不合法");
        }
    }*/

    //删除第一次出现的关键字toRemove
    public void remove(int toRemove){
        int index=search(toRemove);
        if(index==-1){
            System.out.println("没有需要删除的元素");
            return ;
        }
        for(int i=index;i<this.userSized-1;i++){
            this.elem[i]=this.elem[i+1];
        }
        this.userSized--;
    }
    //清楚顺序表中的元素
    public void clear(){
        this.userSized=0;
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos<0||pos>=this.userSized){
            throw new RuntimeException("pos不合法");
        }
        this.elem[pos]=value;
    }
}
