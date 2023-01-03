package com.bit.thread;

/**
 * 懒汉单例
 */
public class SingleLazy {
    //指令重排序和内存可见性
    private  volatile static  SingleLazy singleLazy = null;
    public static SingleLazy getSingleLazy(){
      if (singleLazy==null) {//判断是否加锁  加锁需要CPU从有、用户态切换到核心态(存在消耗)  单例只有一个
          synchronized (SingleLazy.class) {//判断是否创建实例
              if (singleLazy==null) {
                  singleLazy = new SingleLazy();
              }
              return singleLazy;
          }
      }
      return  singleLazy;
    }
    private  SingleLazy(){}

    public static void main(String[] args) {
        SingleLazy singleLazy = SingleLazy.getSingleLazy();
    }
}
