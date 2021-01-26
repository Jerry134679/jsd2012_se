package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前目录下创建一个文件test.txt
        File file=new File("./test.txt");//在相对路径中./可写可不写
        boolean e=file.exists();
        /*
        判断当前File表示的文件或目录是否已经存在，存在返回true
         */
        if(e){
            System.out.println("该文件已存在");
        }else {
            //将文件创建
            file.createNewFile();
            System.out.println("已创建");
        }
    }
}
