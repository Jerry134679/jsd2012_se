package raf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


/**
 * 简易记事本工具
 * 程序启动后要求用户输入一个文件名，然后对该文件进行写操作
 * 之后用户在控制台输入的每一行字符串都写入到该文件中。(不用考虑换行问题)
 * 当用户单独输入"exit"时程序退出
 */
public class Note {
    public static void main(String[] args) throws IOException {

        Scanner scan=new Scanner(System.in);
        System.out.println("输入一个文件名");
        String name=scan.nextLine();
        File file=new File(name);
        file.createNewFile();
        RandomAccessFile raf=new RandomAccessFile(name,"rw");
        System.out.println("写文件,当用户单独输入\"exit\"时程序退出");
        String substance=scan.nextLine();
        while (!"exit".equals(substance))//用常量池里的字面量点方法，避免空指针异常
            {
            byte []data=substance.getBytes("UTF-8");
            raf.write(data);
            substance=scan.nextLine();
        }
        System.out.println("退出");
        raf.close();
    }
}
