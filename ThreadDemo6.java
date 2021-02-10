package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-08
 * @Time: 10:36
 **/


public class ThreadDemo6 {
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isQuit) {
                    System.out.println("忙着呢");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("终止操作");
            }
        };

        t.start();

        Thread.sleep(5000);
        System.out.println("停止");
        isQuit = true;

    }
}
