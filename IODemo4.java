package javaWeb.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-14
 * @Time: 18:19
 **/


public class IODemo4 {
    public static void main(String[] args) {
        //分别使用缓冲区和不使用缓冲区来进行读取一个大文件操作
        testBuffer();
        testNoBuffer();
    }

    private static void testNoBuffer() {
        long beg = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream("d:/big.jpg")){
            int ch = -1;
            while ((ch = fileInputStream.read()) != -1){

            }
        }catch (IOException e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-beg);
    }

    private static void testBuffer() {
        long beg = System.currentTimeMillis();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/big.jpg"))){
            int ch = -1;
            while ((ch = bufferedInputStream.read()) != -1){
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-beg);
    }


}
