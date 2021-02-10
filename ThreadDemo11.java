package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-09
 * @Time: 15:05
 **/


public class ThreadDemo11 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i=0;i<1000_0000;i++){}
            }
        };

        System.out.println("线程启动之前:"+t.getState());

        t.start();
        while(t.isAlive()){
            System.out.println("线程启动中:"+t.getState());
        }

        System.out.println("线程启动之后:"+t.getState());
    }
}
