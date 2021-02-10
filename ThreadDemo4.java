package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-08
 * @Time: 10:11
 **/


public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread("name"){
            @Override
            public void run() {
                while(true){}
            }
        };
    }
}
