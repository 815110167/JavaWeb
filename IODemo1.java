package javaWeb.io;

import java.io.File;
import java.io.IOException;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-14
 * @Time: 12:56
 **/


public class IODemo1 {
    public static void main(String[] args) throws IOException {
/*        File file = new File("d:/test.txt");
        System.out.println("是否存在" + file.exists());
        System.out.println("是否为普通目录" + file.isFile());
        System.out.println("是否为目录" + file.isDirectory());
        file.delete();
        System.out.println("是否存在" + file.exists());
        file.createNewFile();
        System.out.println(File.separator);*/

/*        //目录操作
        File file1 = new File("d:/test_dir/1/2/3/4");
        System.out.println(file1.exists());
        System.out.println(file1.isDirectory());
        file1.mkdirs();
        System.out.println(file1.exists());*/

        //listFiles
        File file2 = new File("d:/test_dir");
        listAllFiles(file2);

    }
    private static void listAllFiles(File f){
        if (f.isDirectory()){
            File[] files = f.listFiles();
            for (File file :files){
                if (file.isDirectory()) {
                    listAllFiles(file);
                }
            }
        }
        else {
            System.out.println(f);
        }
    }
}
