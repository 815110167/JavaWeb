package javaWeb.io;

import java.io.*;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-14
 * @Time: 19:45
 **/


public class IODemo5 {
    public static void main(String[] args) {
        copyFile3();
    }

    private static void copyFile() {
        //处理文本文件,需要使用字符流
        try (FileReader fileReader = new FileReader("d:/test_dir/test.txt");
             FileWriter fileWriter = new FileWriter("d:/test_dir/test1.txt")) {
            char[ ] buffer = new char[1024];
            int length = -1;
            while ((length = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile2() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/test_dir/test.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/test_dir/test1.txt"))){
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = bufferedReader.read())!=-1){
                bufferedWriter.write(buffer,0,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile3() {
        //字符流中的按行读取
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/test_dir/test.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/test_dir/test1.txt"))){
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                bufferedWriter.write(line+"\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
