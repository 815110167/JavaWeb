package javaWeb.thread;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: class
 * @description: .
 * @author: hdc
 * @Date: 2021-02-10
 * @Time: 19:51
 **/


public class ThreadDemo22 {
    //使用这个类来描述当前的工作线程是啥样子的
    static class Worker extends Thread{
        private int id= 0;
        //每个Worker线程都需要从任务队列中取任务
        //需要能够获取到任务队列的实例
        private BlockingQueue<Runnable> queue = null;

        public Worker(BlockingQueue<Runnable> queue,int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            //此处try把while包裹进去了
            //目的是只要线程收到异常就会立刻结束run(结束线程)
            try {
                while(!Thread.currentThread().isInterrupted()){
                    Runnable commmand = queue.take();
                    System.out.println("thread "+id+" running...");
                    commmand.run();
                }
            }catch (InterruptedException e){
                //线程被结束
                System.out.println("线程被终止");
            }
        }
    }

    static class MyThreadPool{
        //这个阻塞队列用于组织若干个任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        //这个list用来阻止若干个工作线程
        private List<Worker> workers = new ArrayList<>();

        private static final int MaxWorkerCount = 10;

        //实现execute方法和shutdown方法
        public void execute(Runnable command) throws InterruptedException {
            //也是使用延时加载的方式来创建线程
            //当线程池中的线程数目比较少的时候,要创建线程来作为工作线程
            //如果线程数目已经比较多了(还没达到设定的阈值),就不用新建线程了
            if(workers.size()<MaxWorkerCount){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }

        //当shutdown结束之后,意味着所有的线程一定都结束了
        public void shutdown() throws InterruptedException {
            //种植所有的线程
            for (Worker worker : workers){
                worker.interrupt();
            }

            //还需要等待每个线程执行结束
            for (Worker worker : workers){
                worker.join();
            }
        }
    }
    static class Command implements Runnable{
        private int num;

        public Command(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行任务:"+num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool();
        for (int i=0;i<1000;i++){
            pool.execute(new Command(i));
        }
        Thread.sleep(2000);
        pool.shutdown();
        System.out.println("线程池已经被销毁");
    }
}
