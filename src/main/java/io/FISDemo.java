package io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;

/**
 * 使用文件输入流读取文件数据
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis
                =new FileInputStream("fos.txt");

        byte[]data=new byte[1000];
        int len=fis.read(data);
        System.out.println("实际读取字节数"+len);
        /*
        将给定的字符串从下标offset处的连续len个字节按照UTF-8编码转换为字符串。
         */
        //String line =new String(data,0,len,"UTF-8").trim();
        String line =new String(data,0,len,"UTF-8");
        System.out.println(line);
        System.out.println(line.length());
        fis.close();
    }
}
