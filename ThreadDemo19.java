package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-10
 * @Time: 11:50
 **/

/**
 * 懒汉模式(延时加载)的实现,Singleton类被加载时不会立刻实例化,而是等到第一次使用这个实例的时候再实例化
 * 懒汉模式比饿汉模式效率更高
 */
public class ThreadDemo19 {
    static class Singleton {
        //把构造方法 变成私有,此时在该类外部就无法new这个类的实例了.
        private Singleton() {

        }

        //在创建static的成员表示Singleton类的唯一的实例
        static volatile Singleton instance = null;

        public static Singleton getInstance() {
            if (instance==null){
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {

    }
}
