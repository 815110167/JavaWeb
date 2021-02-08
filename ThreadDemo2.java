package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-07
 * @Time: 14:37
 **/


public class ThreadDemo2 {
    public static final long count = 10_000_000_000L;
    public static void main(String[] args) {
        //serial();
        concurrency();
    }

    private static void concurrency() {
        long beg = System.currentTimeMillis();

        //匿名内部类:创建了一个没有名字的类,{}中是这个类的具体代码.同时会new出来一个这个类的实例
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int a = 0;
                for (long i = 0;i<count;i++ ){
                    a++;
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                int b = 0;
                for (long i = 0;i<count;i++){
                    b++;
                }
            }
        };
        t1.start();
        t2.start();

        try {
            //线程等待,让主线程等待t1和t2执行结束,然后再继续执行
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //t1 t2和main线程之间都是并发执行的
        //调用了t1.start和t2.start之后,两个新线程正在执行计算过程中,
        //此时主线程仍然会继续执行,下面的end就随之被计算了
        //正确的做法应该是要保证t1和t2都计算完毕,再来计算这个end的时间戳
        long end = System.currentTimeMillis();
        System.out.println("time:"+ (end - beg)+"ms");
    }

    private static void serial() {
        //以1970年1月1日0时0分0秒为基准时刻,计算当前时刻和基准时刻之间的 秒数/毫秒数/微秒数 之差
        long beg = System.currentTimeMillis();

        int a = 0;
        for (long i = 0;i<count;i++ ){
            a++;
        }
        int b = 0;
        for (long i = 0;i<count;i++){
            b++;
        }

        long end = System.currentTimeMillis();
        System.out.println("time:"+ (end - beg)+"ms");
    }
}
