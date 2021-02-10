package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-10
 * @Time: 13:56
 **/


public class ThreadDemo20 {
    static class BlockingQueue {

        private int[] array = new int[1000];
        private volatile int head = 0;
        private volatile int tail = 0;

        private volatile int size = 0;

        public void put(int value) throws InterruptedException {
            synchronized (this) {
                while (size == array.length) {
                    wait();
                }
                array[tail] = value;
                tail++;
                if (tail == array.length) {
                    tail = 0;
                }
                size++;

                notify();
            }
        }

        public int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                while (size == 0) {
                    wait();
                }
                ret = array[head];
                head++;
                if (head == array.length) {
                    head = 0;
                }
                size--;

                notify();
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    try {
                        blockingQueue.put(i);
                        System.out.println("生产元素:" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        producer.start();
        Thread consumer = new Thread() {
            public void run() {
                while (true) {
                    try {
                        int ret = blockingQueue.take();
                        System.out.println("消费元素:" + ret);
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.start();
    }
}
