package javaWeb.thread;

import java.util.Scanner;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-09
 * @Time: 20:07
 **/


public class ThreadDemo15 {
    public static class Counter{
        public volatile int flag = 0;
    }
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                //反复快速的执行循环条件中的比较操作
                while (counter.flag==0){

                }
                System.out.println("循环结束");
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入一个整数");
                counter.flag = scanner.nextInt();
            }
        };
        t2.start();
    }
}
