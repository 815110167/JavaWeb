package javaWeb.io;

import java.io.*;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-14
 * @Time: 20:18
 **/

class Student implements Serializable {
    public String name;
    public int age;
    public int score;

}
public class IODemo6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Student s = new Student();
        s.name = "张三";
        s.age = 20;
        s.score = 100;
        serializeStudent(s);*/

        Student s = deserializeStudent();
        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.score);
    }

    private static void serializeStudent(Student s) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/student.txt"));

        //writeObject集序列化+写文件 两者同时锁定
        objectOutputStream.writeObject(s);
        objectOutputStream.close();
    }

    private static Student deserializeStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/student.txt"));
        Student s = (Student) objectInputStream.readObject();
        return s;
    }
}
