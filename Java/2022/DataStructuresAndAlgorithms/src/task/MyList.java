package task;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-04-24 12:05
 */

public class MyList {
    public static final int capacity = 10;//顺序表初始化的容量
    public int elem[];
    public int userSized;

    public MyList() {
        this.userSized = 0;
        this.elem = new int[capacity];
    }

    // 打印顺序表
    public void display() {
        for(int i=0;i<this.elem.length;i++){
            System.out.print(elem[i]+" ");
        }
    }

    /**
     * 在 pos 位置新增元素data
     *
     * @param pos
     * @param data
     */
    public void add(int pos, int data) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        if (pos < 0 || pos > userSized) {
            return;
        } else {
            for (int i = userSized - 1; i >=pos; i--) {
                this.elem[i + 1] = this.elem[i];
            }
            this.elem[pos] = data;
            this.userSized++;
        }
    }

    //判断顺序表是否已满
    private boolean isFull() {
        if (this.userSized == this.elem.length) {
            return true;
        }
        return false;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.elem.length;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.elem.length;i++){
            if(this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(isEmpty()){
            throw  new RuntimeException("顺序表为空");
        }else{
            if(pos<0||pos>this.userSized){
               throw  new RuntimeException("pos位置非法");
            }else{
                return this.elem[pos];
            }
        }
    }

    /**
     * 判断顺序表是否为空
     * @return
     */
    private boolean isEmpty() {
        if(this.userSized==0){
            return true;
        }
        return  false;
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos<0||pos>this.userSized){
            throw new RuntimeException("pos位置非法");
        }else{
            this.elem[pos]=value;
        }
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index =searchIndex(toRemove);
        if(index==-1){
            System.out.println("没有要删除的元素！");
        }
            for (int i=index;i<this.elem.length;i++){
                this.elem[i]=this.elem[i+1];
        }
        this.userSized--;
    }
    //查找索引
    private int searchIndex(int toRemove) {
      for(int i=0;i<this.elem.length;i++){
          if(this.elem[i]==toRemove){
              return i;
          }
      }
      return -1;
    }

    // 获取顺序表长度
    public int size() {
        return this.userSized;
    }

    // 清空顺序表
    public void clear() {
        this.userSized=0;
    }
}
