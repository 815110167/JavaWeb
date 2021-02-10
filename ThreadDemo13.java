package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-09
 * @Time: 19:08
 **/


public class ThreadDemo13 {
    static class Test{
        private Object o = new Object();
        public void method(){
            synchronized (this){
                System.out.println("hehe");
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.method();
    }
}
