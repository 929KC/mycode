package org.example.thread.bit2;

public class HungrySingleton {
    /**
     * 类加载的时候创建出HungrySingleton对象,并用静态差成员变量保存。
     */
    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {
    }

    /**
     * 提供静态方法获取单例
     * @return
     */
    public static HungrySingleton getSingleton() {
        return singleton;
    }
}
