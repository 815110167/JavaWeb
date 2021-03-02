package javaWeb.io;

import java.io.*;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-14
 * @Time: 17:00
 **/


public class IODemo3 {
    public static void main(String[] args) {
        copyFile2();
    }

    private static void copyFile() throws IOException {
        //需要创建的实例是BufferedInputStream和BufferedOutputStream
        //要创造这样的实例,需要先创建FileInputStream和FileOutputStream
        FileInputStream fileInputStream = new FileInputStream("d:/test_dir/rose.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:/test_dir/rose2.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, length);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    private static void copyFile2() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/test_dir/rose.jpg"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/test_dir/rose2.jpg"))) {
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
