package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 从文件中获取数据
 */
public class RAFDemo2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf=new RandomAccessFile("raf.dat","r");
        /*
            raf.dat文件数据
            00000000 000000010
         */
        /*
        int read()
        从文件中读取1个字节，并以int型返回。
        实际读取的字节是在返回的int值对应的二进制的低八位上。
        但如果返回为-1，则表示文件末尾上。EOF:end of file
         */
        //00000000 00000000 00000000 00000000
        int d=raf.read();//0
        System.out.println(d);
        //00000000 00000000 00000000 00000010
        int e=raf.read();
        System.out.println(e);//2
        //11111111 11111111 11111111 11111111
        int f=raf.read();
        System.out.println(f);//-1文件末尾
        raf.close();
    }
}
