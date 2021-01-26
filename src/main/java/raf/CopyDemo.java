package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件复制
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        /*
        复制原理：从源文件中顺序读出每个字节并写入另一个字节里
         */
        RandomAccessFile src=new RandomAccessFile("123.jpg","r");
        RandomAccessFile desc=new RandomAccessFile("1234.jpg","rw");
        int a;
        //读一次写一次完成复制
        while ((a=src.read())!=-1){
            desc.write(a);
        }
        System.out.println("复制完毕");
        src.close();
        desc.close();
    }
}
