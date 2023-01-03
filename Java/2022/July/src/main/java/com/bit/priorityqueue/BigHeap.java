package com.bit.priorityqueue;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-15 14:38
 */

public class BigHeap {
    private int userSized;
    public int [] elem;

    public  BigHeap(){
        this.userSized=0;
        this.elem=new int[10];
    }

    public void init(int [] array){
        this.elem= Arrays.copyOf(array,array.length);
        this.userSized=array.length;
    }

    /**
     * 时间复杂度:o(n)
     * parent:根节点
     */
    public void createHeap(){
        for(int parent=(userSized-1-1)/2;parent>=0;parent--){
            shiftDown(parent,userSized);
        }
    }

    /**
     *
     * @param parent
     * @param len
     */
    public void shiftDown(int parent ,int len){
        int child=2*parent+1;//左孩子
        while(child<len){//保证有左孩子
            if(child+1<len&&elem[child]<elem[child+1]){//有右孩子
                child++;
            }
            if(elem[child]>elem[parent]){
                swap(elem,child,parent);
                //因为是从向下调整,调整后只是当前的树为最大堆,还需向下继续调整,直至所有的树都满足最大堆
                parent= child;
                child=parent*2+1;
            }else{
                break;
            }
        }
    }

    /**
     *
     * @param array
     * @param i
     * @param j
     */
    public void swap(int [] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    /**
     * 插入元素后需要向上调整,保障堆依旧为最大堆
     * @param child
     */
    public void shiftUp(int child){
        int parent=(child-1)/2;
        while (child>0){
            if(elem[child]>elem[parent]){
                swap(elem,child,parent);
                child=parent;
                parent=(child-1)/2;
            }else{
                break;
            }
        }
    }

    /**
     *
     * @param val
     */
    public void offer(int val ){
        if(isFull()){
            this.elem=Arrays.copyOf(elem,2*elem.length);
        }
        this.elem[userSized]=val;
        this.userSized++;
        shiftUp(userSized-1);
    }

    /**
     * 出队:将第一个值与最后一个值交换,交换后userSized,然后向下调整保证堆为最大堆
     * @return
     */
    public int poll(){
        if(isEmpty()){
            return -1;
        }
        int old=elem[0];
        swap(elem,0,userSized-1);
        shiftDown(0,userSized);
        return old;
    }

    private boolean isEmpty() {
        return userSized==0;
    }

    public boolean isFull(){
        return this.userSized==elem.length;
    }

    public  void heapSort(){
        int end=this.userSized-1;
        while(end>0){
            swap(elem,0,end);
            shiftDown(0,end);
            end--;
        }
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
      if (!isEmpty()){
          return elem[0];
      }
        return -1;
    }
}
