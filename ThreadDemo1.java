package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-07
 * @Time: 14:20
 **/

/**
 * 为了观察线程的个数,可以借助第三方工具来查看线程中的线程情况
 *  例如:jdk自带的jconsole
 */
public class ThreadDemo1 {
    static class Mythead extends Thread{
        @Override
        public void run() {
            System.out.println("新线程");
        }
    }

    //main是主线程
    public static void main(String[] args) {
        //创建线程需要Thread类,来创建一个Thread的实例
        //另一方面还需要给这个线程致电给,需要执行那些指令/代码
        //指定指令的方式有很多种方式,此处使用一种简单的,直接继承
        //重写Thread类中的run方法

        //当Thread对象被创建出来时.内核中并没有产生一个线程(PCB)
        Mythead mythead = new Mythead();

        //执行start方法时,才真正创建出了一个线程
        //此时内核中才随之出现了一个PCB,这个PCB就会让对应让CPU来执行该线程的代码(上面的run)
        mythead.start();
    }
}
