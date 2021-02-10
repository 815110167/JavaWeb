package javaWeb.thread;

import java.util.Scanner;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-09
 * @Time: 19:10
 **/


public class ThreadDemo14 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                synchronized (locker1.getClass()){
                    System.out.println("请输入一个整数");
                    int num = scanner.nextInt();//如果用户暴怒输入,就会一直阻塞再nextInt,这个锁就被一直占有
                    System.out.println("num="+num);
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while(true){
                    synchronized (locker2.getClass()){
                        System.out.println("线程2获取到锁啦");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t2.start();
    }
}
