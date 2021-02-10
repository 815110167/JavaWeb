package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-08
 * @Time: 10:42
 **/


public class ThreadDemo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                //使用线程内部的标记为来判定
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("忙着呢");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("终止操作");
            }
        };

        t.start();

        Thread.sleep(5000);
        System.out.println("停止");
        t.interrupt();

    }
}
