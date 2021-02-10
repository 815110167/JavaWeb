package javaWeb.thread;

/**
 * @program: class
 * @description: .
 * @author: hdc
 * @Date: 2021-02-09
 * @Time: 21:00
 **/


public class ThreadDemo16 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object){
            System.out.println("等待前");
            object.wait();
            System.out.println("等待后");
        }
    }
}
