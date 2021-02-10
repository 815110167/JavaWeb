package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-09
 * @Time: 14:06
 **/


public class ThreadDemo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i =0;i<10;i++){
                    System.out.println("我是线程1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            public void run() {
                for(int i =0;i<10;i++){
                    System.out.println("我是线程2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();
        t1.join(); //join起到的效果就是等待线程结束当执行到这行代码时,程序就阻塞了.一直阻塞到t1执行完毕
        t2.start();
        t2.join();
    }
}
