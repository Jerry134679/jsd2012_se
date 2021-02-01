package exception;

import java.io.*;

/**
 * JDK7之后，java推出了一个新的特性：自动关闭
 */
public class AutocloseableDemo {
    public static void main(String[] args) {
        //try后面的()中初始化的类必须实现Autocloseable接口
        try(
                //编译器以后便会将try()里初始化的类在Finally中调用close
                //编译后的代码相当于是FinallyDemo2的样子
                FileOutputStream fos=new FileOutputStream("fos.clo se")
                //流连接初始化写法
//                PrintWriter pw=new PrintWriter(
//                        new BufferedOutputStream(
//                                new OutputStreamWriter(
//                                        new FileOutputStream()
//                                )
//                         )
//                );
        ){

            fos.write(123);
            fos.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }

    }
}
