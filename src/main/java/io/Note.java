package io;

import java.io.*;
import java.util.Scanner;

/**
 * 简易记事本功能
 * 程序启动后要求用户输入文件名，然后对文件进行写操作
 * 之后用户输入的每一行字符串都要按行写入到文件中
 *
 * 要求：创建PrintWriter并且自行创建流连接完成
 */
public class Note {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scan=new Scanner(System.in);
        System.out.println("输入文件名");
        String name=scan.nextLine();
        FileOutputStream fos=new FileOutputStream(name,true);//文件流,加true可以实现续写
        OutputStreamWriter ost=new OutputStreamWriter(fos,"UTF-8");//转换流
        BufferedWriter bw=new BufferedWriter(ost);//缓冲流
        PrintWriter pw=new PrintWriter(bw,true);//字节流,加true调用println时自动行刷新
        /*
        当创建PW时第一个参数为流，则可以在传入一个boolean型的参数
        如果这个值为true则当前PW具有自动行刷新功能。
        即：每当我们调用println方法后会自动flush

         */
        System.out.println("写入exit退出");
//        String str=scan.nextLine();
//        while(!("exit".equals(str))) {
//            pw.println(str);
//            str=scan.nextLine();
//        }
        while(true){
            String str=scan.nextLine();
            if("exit".equals(str)){
               break;
            }
            pw.println(str);
            //pw.flush();写一句打印一句
        }
        System.out.println("结束");
        pw.close();
    }
}
