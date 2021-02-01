package io;

import java.io.*;

/**
 * 使用转换流读取文本数据
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        //将osw.txt.文件中的字符读取回来
        FileInputStream fis=new FileInputStream("osw.txt");
        InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
        int d;
        while ((d=isr.read())!=-1){
            System.out.println(d);
            System.out.println((char)d);
        }
//        int d=isr.read();//实际返回一个char
//        System.out.println((char)d);
        /*
        int read()
        字符流的read()方法是读取一个字符，返回的是一个char
        但实际是用int 型返回，因此该int值对应的2进制是“低16位”
        有效，如果int返回值为-1则表示文件末尾
         */
        isr.close();
    }
}
