package com.bit.thread;

/**
 * 单例模式:本质上就是借助编程语言自身的语法特性,强行限制某个类,不能创建多个实例
 * 类对象是通过JVM加载的.class文件来的,此时类对象,其实在JVM中也是单例,换句话说,JVM针对某个.class文件只会加载一次
 * ,也就是只有一个类对象,类对象上面的成员,也就只有一份。
 * 饿汉单例
 */
public class HungrySingleton {
    //类加载时机创建出来的
    private  static HungrySingleton instance = new HungrySingleton();

    public static  HungrySingleton getHungrySingleton(){
        return  instance;
    }

}
