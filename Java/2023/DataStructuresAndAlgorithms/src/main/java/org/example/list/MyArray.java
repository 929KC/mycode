package org.example.list;

import java.util.Arrays;

/**
 * 顺序表
 */
public class MyArray {
    /**
     * 记录数组中的实际元素
     */
    private int useSize;
    private int[] array;
    /**
     * 数组初始化的容量
     */
    private static final int capacity = 3;

    /**
     * 创建一个数组
     */
    public MyArray() {
        this.array = new int[capacity];
    }

    /**
     * 判断数组是否为空
     * @return
     */
    private boolean isEmpty() {
        if (this.useSize == 0){
            return true;
        }
        return  false;
    }
    /**
     * 判断数组是否为满
     * @return
     */
    private boolean isFull() {
        if (array.length==this.useSize) {
            return true;
        }
        return  false;
    }
    public void addElement(int position, int element) {
        if (isFull()) {
            this.array= Arrays.copyOf(this.array, this.useSize*2);
        }
        if (position<0||position>this.useSize) {
            return;
        }
        for (int i = this.useSize-1;i>=position;i--) {
            this.array[i+1]=this.array[i];
        }
        this.array[position] = element;
        useSize++;
    }

    /**
     * 打印数组中的元素
     */
    public void display() {
       for (int i = 0; i <this.useSize;i++) {
           System.out.print(this.array[i]+" ");
       }
    }
    public void removeElement(int index) {
        for (int i = index;i<this.useSize-1;i++) {
            this.array[i] = this.array[i+1];
        }
        this.useSize--;
    }
    public int getElementByIndex(int index) {
        if (index<0 || index>=this.useSize) {
            System.out.println("index不合法");
        }
        for (int i = 0;i<this.useSize;i++) {
            if(index==i) {
                return this.array[index];
            }
        }
        return -1;
    }
    public int getElementIndex(int element) {
        for (int i = 0;i<this.useSize;i++) {
            if(this.array[i]==element) {
                return i;
            }
        }
        return -1;
    }
    public void setElementByIndex(int index,int element) {
        if (index<0 || index>=this.useSize) {
            System.out.println("index不合法");
        }
        this.array[index] = element;
    }
    public boolean isContainerElement(int element) {
        if (!isEmpty()) {
            for (int i = 0;i<this.useSize;i++) {
                if(this.array[i]==element) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getArrayLen() {
        return  this.useSize;
    }

    public void clearArray() {
        this.useSize = 0;
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.addElement(0,1);
        myArray.addElement(1,2);
        myArray.addElement(2,3);
        myArray.display();
        System.out.println();
        myArray.addElement(3,4);
        myArray.display();
        myArray.addElement(2,99);
        System.out.println();
        myArray.display();
        System.out.println(myArray.isContainerElement(99));
        System.out.println(myArray.getArrayLen());
        System.out.println(myArray.getElementByIndex(1));
        myArray.removeElement(2);
        System.out.println();
        myArray.display();
    }
}
