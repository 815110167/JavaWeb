package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-07
 * @Time: 15:07
 **/


public class ThreadDemo3 {

    //5.
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("新线程");
        } );
        t.start();
    }

    //4.
/*    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程");
            }
        };
        Thread t = new Thread(runnable)
    }*/


    //3
/*    //Runnable 本质上就是描述了一段要执行的任务代码
    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("新线程");
        }
    }
    public static void main(String[] args) {
        Thread  t= new Thread(new MyRunnable());
        t.start();
    }*/
}
