package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 缓冲字符输出流
 * java.io.BufferedWriter
 * 内部有缓冲区，可以块写文本数据来加快写出数据的速度
 *
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流，内部总是连接BufferedWriter作为其
 * 缓冲功能
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //向 pw.txt文件中写入字符串
        /*
           PW提供了直接对文件做操作的构造方法
           PrintWriter(String path)
           PrintWriter(File file)
         */
        PrintWriter pw=new PrintWriter("pw.txt");
        pw.println("让我掉下眼泪的");
        pw.println("不止昨夜的酒");
        System.out.println("结束");
        pw.close();
    }
}