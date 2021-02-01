package io;

import java.io.*;

/**
 * 使用流连接形式创建PW完成文本数据的写出操作
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        //向pw2.txt文件中写入数据
        FileOutputStream fos=new FileOutputStream("pw2.txt");
        /*
        高级流，转换流
        1.负责衔接字符流与字节流
        2.负责将写出的字符按照指定的字符集转换为字节
         */
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        //高级流，缓冲字符输出流负责块写文本加速
        BufferedWriter bw=new BufferedWriter(osw);
        //高级流，PW负责按行写字符串，并可以自动行刷新
        PrintWriter pw=new PrintWriter(bw);
        pw.println("让我依依不舍地");
        pw.println("是你的温柔");
        System.out.println("结束");
        pw.close();
    }
}
