package io;

import java.io.*;

/**
 * 使用缓冲流完成文件复制
 *
 * 缓冲流：java.io.BufferedInputStream和BufferedOutputStream
 * 它们是一对高级流，在流连接的作用是提高读写效率
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("123.mp4");
        BufferedInputStream bis=new BufferedInputStream(fis);
        FileOutputStream fos=new FileOutputStream("1234.mp4");
        BufferedOutputStream bos=new  BufferedOutputStream(fos);
        int d;
        long start=System.currentTimeMillis();
        /*
        缓存流内部维护着一个字节数组，默认为8k无论我们读写时用哪种方式
        最终都会被缓冲流转化为块读写8k8k的进行来保证读写效率
         */
        while ((d=bis.read())!=-1){
            bos.write(d);
        }
        long end=System.currentTimeMillis();
        System.out.println("结束耗时"+(end-start)+"ms");
        bis.close();
        bos.close();

    }
}
