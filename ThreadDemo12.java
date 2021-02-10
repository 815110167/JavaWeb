package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-09
 * @Time: 15:14
 **/


public class ThreadDemo12 {
    static class Counter{
        public int count = 0;
        //进入increase方法之前会先尝试加锁,increase方法执行完毕之后就会自动解锁
        //加锁解锁都由一个关键字来包办了,这样的好处就是避免出现忘记解锁的情况
        synchronized public void increase(){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<50000;i++){
                    counter.increase();
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run() {
                for (int i = 0;i<50000;i++){
                    counter.increase();
                }
            }
        };
        t2.start();

        t1.join();
        t2.join();

        //两个线程,各自自增50000次,最终预期结果,应该是100000次
        System.out.println(counter.count);
    }
}
