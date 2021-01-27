package raf;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 使用RAF读写基本类型数组，以及RAF指针操作
 */
public class RAFDemo3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf=new RandomAccessFile("raf.txt","rw");
        //获取RAF指针位置，默认从0开始
        long pos=raf.getFilePointer();
        System.out.println("pos:"+pos);
        /*
        向文件中写入一个int 最大值
        01111111 11111111 11111111 11111111
        imax>>>24
        00000000 00000000 00000000 01111111
        imax>>>16
        00000000 00000000 01111111 11111111
        imax>>>8
        00000000 01111111 11111111 11111111
        raf.dat文件数据
        01111111 11111111 11111111 11111111
         */
        int imax=Integer.MAX_VALUE;
        raf.write(imax>>>24);
        raf.write(imax>>>16);
        raf.write(imax>>>8);
        raf.write(imax>>>0);
        System.out.println("pos:"+raf.getFilePointer());
        System.out.println("写出完毕");
        /*
        RAF提供了方便写出基本类型数据的方法
         */
        raf.writeInt(imax);//连续写4个字节，将int值写出，等同上述代码
        raf.writeLong(123L);
        raf.writeDouble(123.123);
        System.out.println("pos:"+raf.getFilePointer());
        System.out.println("写出完毕");
        raf.seek(0);
        System.out.println("pos:"+raf.getFilePointer());
        int d=raf.readInt();//从指针的位置开始往后全部读取
        System.out.println(d);//int 最大值
        System.out.println("pos:"+raf.getFilePointer());//4
        //读取long值
        raf.seek(8);
        long l=raf.readLong();
        System.out.println(l);
        System.out.println("pos:"+raf.getFilePointer());
        double dou=raf.readDouble();
        System.out.println(dou);
        System.out.println("pos:"+raf.getFilePointer());

        //修改raf.dat文件中long所在的位置的值改位456
        //1将指针移到long值的开始位置
        raf.seek(8);
        //2重新写入新的long值来覆盖原有的数据
        raf.writeLong(456);

        raf.seek(8);
        l=raf.readLong();
        System.out.println(l);
        raf.close();
    }
}
