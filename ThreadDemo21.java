package javaWeb.thread;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-10
 * @Time: 15:15
 **/


public class ThreadDemo21 {

    //优先队列中的元素必须是可比较的
    //比较规则的指定主要是两种方式
    //1.让Task实现Comparable接口
    //2.让优先队列构造的时候,传入一个比较器对象(Comparator)
    static class Task implements Comparable<Task> {
        //Runnable中有一个run方法,可以借助这个run方法来描述要执行的具体的任务是啥.
        private Runnable command;
        //time 表示什么时候来执行comand,是一个绝对时间(ms级别的时间戳)
        private long time;

        //参数表示多少毫秒之后执行(相对时间)
        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }

        //执行任务的具体逻辑
        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time - o.time);
        }
    }

    static class Worker extends Thread {
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;

        public Worker(PriorityBlockingQueue<Task> queue, Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    //1.取出除队首元素,
                    Task task = queue.take();
                    //2.检查当前任务时间是否到了
                    long curTime = System.currentTimeMillis();
                    if (task.time > curTime) {
                        queue.put(task);
                        synchronized (mailBox){
                            mailBox.wait(task.time-curTime);
                        }
                    } else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    static class Timer {
        //为了避免忙等,需要使用wait对象
        private Object mailBox = new Object();
        //定时器的基本构成有三个
        //1.用一个类来描述"任务"
        //2.用一个阻塞优先队列来组织若干个任务,让对沙鸥元素就是时间最早的任务,如果队首元素未到,那么其他元素也肯定不能执行.
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        //3.用一个线程来循环扫描当前的阻塞队列的队首元素,时间到,就执行指定任务
        public Timer() {
            //1.创建线程
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }

        //4.提供一个方法,让调用者能把任务"安排"进来
        public void schedule(Runnable command, long after) {
            Task task = new Task(command, after);
            queue.put(task);
            synchronized (mailBox){
                mailBox.notify();
            }
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hehe");
                timer.schedule(this, 2000);
            }
        }, 2000);
    }
}
