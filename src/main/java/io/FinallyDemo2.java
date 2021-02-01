package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 在IO操作中使用异常处理机制
 */
public class FinallyDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream("fos.dat");
            fos.write(2);
            fos.close();
        }catch(IOException io){
            io.printStackTrace();
            //处理异常
        }finally{
            try{
                if(fos!=null){
                    fos.close();
                }
            }catch (IOException io){
                io.printStackTrace();
            }
        }
    }
}
