package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-09
 * @Time: 13:59
 **/


public class ThreadDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        sleep(100);
                        System.out.println("新线程");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        System.out.println("我是主线程");
        t.sleep(100);
    }
}
