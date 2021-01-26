package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * RAF是专门用来读写文件的类，其基于指针对文件进行随机读写访问
 */
public class RAFDemo {
    public static void main(String[] args) throws IOException {
        /*
            RAF常用构造器
            RandomAccessFile(File file ,String mode)
            RandomAccessFile(String path,String mode)
            第一个参数为要进行读写的文件，可以传入File对象，也可以传入该文件路径
            第二个参数为操作模式：
            1："r"只读模式，仅对该文件进行读取数据
            2："rw"读写模式，对文件可进行读写操作
         */
        RandomAccessFile raf=new RandomAccessFile("./raf.dat","rw");
        //向文件中写出一个字节的二进制数据
        /*
            void write (int d)
            向文件中写入1个字节，写入的是给定的int值所对应的二进制的“低八位”
            int整数型0的二进制：
            00000000 00000000 00000000 00000000

            write 方法写的低八位
                                       vvvvvvvv
            00000000 00000000 00000000 00000000
            int整数型2的二进制：
            00000000 00000000 00000000 00000010

            write 方法写的低八位
                                       vvvvvvvv
            00000000 00000000 00000000 00000010
         */
        raf.write(255);
        raf.write(2);
        System.out.println("写出完毕！");
        /*
        00000000 00000010
         */
        raf.close();//最终都要调用close方法
    }
}
