package io;

import java.io.*;

/**
 * 字符流 java.io.Reader和java.io.Writer
*  java将流按照读写单位划分为字节流与字符流
*  字节流的超类是:java.io.InputStream和OutputStream
*  而字符流的超类是:java.io.Reader和java.io.Writer
*  它们的区别是读写单位不同，字节流最小读写单位为一个字节，而字符流
*  最小的读写单位为一个char(一个字符)
 *
 * 转换流：java.io.InputStreamReader和java.io.OutputStreamWriter
 * 转换流是常用的字符流实现类，他们是一对高级流，实际开发中我们不会直接
 * 使用它们，但是他们在流连接中是非常重要的一环.
 *
 * 因为其他高级字符流都有一个共同特点，在流连接中只能连接其它字符流，而真实都读写设备的低级流通常都是字节流，
 * 这会导致 这些高级字符流不能直接连接字节流，而转换流就是起到“转换器”作用，它可以连接字节流，并且它又是字符流，
 * 其他字符流可以连接它，而它就负责把字符转化为字节。
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向文件中写入字符串
        FileOutputStream fos=new FileOutputStream("osw.txt");
        OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
        osw.write("夜空中最亮的星,");
        osw.write("能否听清");
//        fos.write("".getBytes("UTF-8"));
//        fos.write("".getBytes("UTF-8"));
//        fos.close();
        System.out.println("结束");
        osw.close();
    }
}
