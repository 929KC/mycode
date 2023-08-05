package org.example.thread.juc;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferencedDemo {
    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start ...");
        //获取A的值
        String prev = ref.getReference();
        //获取版本号
        int stamp = ref.getStamp();
        System.out.println(stamp);
        update();
        Thread.sleep(1000);
        System.out.println("change A->Z "+ref.compareAndSet(prev, "Z",stamp,stamp+1));
    }

    private static void update() throws InterruptedException {
        new Thread(() -> {
            System.out.println("change A-B");
            ref.compareAndSet(ref.getReference(), "B",ref.getStamp(), ref.getStamp()+1);
            System.out.println("t1的版本号:"+ref.getStamp());
            },"t1").start();
        new Thread(() -> {
            System.out.println("change B-A");
            ref.compareAndSet(ref.getReference(), "A",ref.getStamp(), ref.getStamp()+1);
            System.out.println("t2的版本号:"+ref.getStamp());
        },"t2").start();
    }

}
