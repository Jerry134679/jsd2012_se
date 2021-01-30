package raf;

import javax.crypto.spec.PSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 通过提高每次读写的数据量减少实际读写的次数可以提高效率。
 * 单字节读写是随机读写
 * 一组字节读写是块读写
 * 对于机械键盘而言，单字节读写几乎没有效率可言，块读写效率很好。
 * 对于大部分硬件而言，减少硬件读写次数可以提高效率。
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile src=new RandomAccessFile("IconWorkshop.exe","r");
        RandomAccessFile desc=new RandomAccessFile("IconWorkshop_cp.exe","rw");
        /*
        RAF提供的块读写方法：
        块写：
        void write (byte[]data)
        一次性将给定的字节数组中所有字节写入文件

        void write (byte[]data,int offset,int len)
        一次性将给定的数组中从下标offset处开始的连续len个字节写入文件

        快读：
        int read(byte[]data)
        一次性从文件中读取给定的字节数组data总长度的字节量并将读取到的字节顺序的存入到该数组中。
        返回值为实际读取到的字节量。如果返回值为-1则表示读取到了文件末尾。

        文件数据：、
        10010011 10001111 10011111 00100101 00001111 1100100

        块读操作：
        byte[]data=new byte[1024*10];
        data=[00000000,00000000,00000000,00000000,00000000,00000000....]

        int len=raf.read(data);
        data=[10010011 ,10001111 ,10011111 ,00100101 ,00001111 ,1100100,00000000....]
        len=6;//read方法返回值为6说明本次实际只读到5个字节

        与单字节的区别：
        int d=raf.read();//读取一个字节，返回值就是实际读取的字节数据
        d:00000000 00000000 00000000 00000000  10010011//该字节放在低八位上
         */
        int len;//记录每次块读数据后，实际读取到的字节数
        /*
        00000000 8位二进制 1byte 1字节
        1024byte 1kb
        1024kb 1mb
        1024mb 1gb
        1024gb 1tb
         */
        byte []data=new byte[1024*10];//10kb
        long start = System.currentTimeMillis();
        while ((len=src.read(data))!=-1){
            //desc.write(data);//写10kb
            desc.write(data,0,len);//都多少写多少
        }
        long end=System.currentTimeMillis();
        System.out.println("复制完毕！耗时"+(end-start)+"ms");
        src.close();
        desc.close();
    }
}
