package javaWeb.thread;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-10
 * @Time: 11:38
 **/

/**
 * 饿汉模式的单例实现,"饿"指的是,只要类被加载,实例就会立刻创建
 */
public class ThreadDemo18 {
    //创建一个表示单例的类,这个类只能有一个实例
    static class Singleton {
        //把构造方法 变成私有,此时在该类外部就无法new这个类的实例了.
        private Singleton() {

        }

        //在创建static的成员表示Singleton类的唯一的实例
        static Singleton instance = new Singleton();

        public static Singleton getInstance() {
            return instance;
        }

    }

    public static void main(String[] args) {
        //此处的getinstance就是获取该类实例的唯一方式,不应该是用其他方式来创建实例了
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s == s2);
    }
}
