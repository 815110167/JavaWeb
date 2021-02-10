package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-09
 * @Time: 14:24
 **/


public class ThreadDemo10 {
    public static void main(String[] args) {
        for (Thread.State state: Thread.State.values()){
            System.out.println(state);
        }
    }
}
