package javaWeb.io;

import java.io.*;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-14
 * @Time: 14:04
 **/


public class IODemo2 {
    public static void main(String[] args) throws IOException {
        copyFiles("d:/test_dir/1/rose.jpg", "d:/test_dir/1/rose1.jpg");
    }

    private static void copyFiles(String scrPath, String desPath) throws IOException {
        //打开文件
        FileInputStream fileInputStream = new FileInputStream(scrPath);
        FileOutputStream fileOutputStream = new FileOutputStream(desPath);

        //读取文件
        byte[] buffer = new byte[1024];
        //单次读取的内容是存在上限,所以需要搭配循环使用
        int len = -1;
        while ((len = fileInputStream.read(buffer)) != -1) {
            //读取成功,就写入到另一个文件中
            //因为len的值,不一定和缓冲区一样长
            fileOutputStream.write(buffer, 0, len);
        }

        fileInputStream.close();
        fileOutputStream.close();

    }

    private static void copyFiles2(String scrPath, String desPath) {
        //打开文件
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(scrPath);
            fileOutputStream = new FileOutputStream(desPath);

            //读取文件
            byte[] buffer = new byte[1024];
            //单次读取的内容是存在上限,所以需要搭配循环使用
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                //读取成功,就写入到另一个文件中
                //因为len的值,不一定和缓冲区一样长
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFiles3() {
        try (FileInputStream fileInputStream = new FileInputStream("d:/test_dir/rose.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("d:/test_dir/rose2.jpg")) {
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
