package org.example.thread.bit2;

public class SlackerSingleton {

    private static volatile SlackerSingleton singleton = null;

    private SlackerSingleton() {
    }

    /**
     * 提供静态方法获取单例
     *
     * @return
     */
    public static SlackerSingleton getSingleton() {
        //需要使用的时候创建对象
        if (singleton == null) {
            synchronized (SlackerSingleton.class) {
                if (singleton == null) {
                    singleton = new SlackerSingleton();
                }
            }
        }
        return singleton;
    }
}
