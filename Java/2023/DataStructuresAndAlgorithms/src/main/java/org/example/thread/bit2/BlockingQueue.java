package org.example.thread.bit2;

public class BlockingQueue {
    /**
     * 队列数据
     */
    private int[] elem = new int[100];
    /**
     * 队头指针
     */
    private int head;
    /**
     * 队尾指针
     */
    private int tail;
    /**
     * 队列元素个数
     */
    private int size;


    /**
     * 出队头元素
     * @return
     */
    public Integer take() throws InterruptedException {
        synchronized (this) {
            if (size == 0) {
                //队列为空
                wait();
            }
            int ret = elem[head];
            head++;
            //作用等价于 head %= elem.length
            if (head >= elem.length) {
                head = 0;
            }
            size--;
            notifyAll();
            return ret;
        }
    }

    /**
     * 入队尾元素
     * @param val
     */
    public void put(int val) throws InterruptedException {
        synchronized (this) {
            while (size == elem.length) {
                //队列满
                wait();
            }
            elem[tail++] = val;
            //作用等价于 tail %= elem.length
            if (tail >= elem.length) {
                tail = 0;
            }
            size++;
            notifyAll();
        }
    }

}
