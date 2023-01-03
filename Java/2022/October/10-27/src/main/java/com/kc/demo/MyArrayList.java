package com.kc.demo;

import java.util.Arrays;

public class MyArrayList {
    private static int[] elementData;
    private static final int CAPACITY = 5;//初始化数组的容量
    private int size;

    public MyArrayList() {
        this.size = 0;
        elementData = new int[CAPACITY];
    }

    /**
     * 遍历数组
     */
    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elementData[i] + " ");
        }
        System.out.println();
    }

    /**
     * 新增元素,默认在数组末尾添加元素
     *
     * @param element
     */
    public void add(int element) {
        if (isFull()) {
            this.elementData = Arrays.copyOf(this.elementData, this.elementData.length * 2);
        }
        this.elementData[this.size++] = element;
    }

    /**
     * 在指定位置插入元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        if (isFull()) {
            this.elementData = Arrays.copyOf(this.elementData, this.elementData.length * 2);
        }
        //判断index合法
        if (index < 0 || index > this.size) {
            return;
        }
        for (int i = this.size-1; i >= index; i--) {
            this.elementData[i + 1] = this.elementData[i];
        }
        this.elementData[index] = element;
        this.size++;
    }

    /**
     * 删除第一次出现的关键字key
     * @param key
     */
    public void remove(int key) {
        int index = searchIndex(key);
        if (index<0||index>this.size) {
            throw new RuntimeException("index不合法");
        }
        for (int i=index; i<this.size-1; i++) {
            this.elementData[i] = this.elementData[i+1];
        }
        this.size--;
    }

    /**
     * 查找该元素数组中第一次出现的位置
     * @param key
     * @return
     */
    private int searchIndex(int key){
      for (int i=0;i<this.size;i++) {
          if (this.elementData[i]==key) {
              return i;
          }
      }
      return -1;
    }

    /**
     * 判断数组中是否包含该元素
     * @param toFind
     * @return
     */
    public boolean contains(int toFind) {
        if (isEmpty()){
            return true;
        }
        for (int i=0;i<this.size;i++) {
            if (this.elementData[i]==toFind) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断数组是否已经满了
     * @return
     */
    private boolean isFull() {
        if (this.size == CAPACITY) {
            return true;
        }
        return false;
    }

    /**
     * 查找某个元素对应的位置(从头到尾)
     * @param toFind
     * @return
     */
    public int indexOf(int toFind) {
        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找某个元素对应的位置(从尾都头)
     * @param toFind
     * @return
     */
    public int lastIndexOf(int toFind) {
        for (int i=this.size-1;i>=0;i--) {
            if (this.elementData[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 给 pos 位置的元素设为 value
     * @param pos
     * @param value
     */
    public void set(int pos, int value) {
        if (pos < 0 || pos > this.size) {
            throw new RuntimeException("pos不合法");
        }
        this.elementData[pos] = value;
    }

    /**
     *  pos 位置的元素
     * @param pos
     * @return
     */
    public int get(int pos) {
        if (isEmpty()) {
            throw new RuntimeException("MyArrayList为空");
        }
        if (pos < 0 || pos > this.size) {
            throw new RuntimeException("pos位置不合法");
        }
        return this.elementData[pos];
    }

    /**
     * 判断数组是否为空
     * @return
     */
    private boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 返回数组的长度
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 清空数组
     */
    public void clear(){
        this.size = 0;
    }
}
