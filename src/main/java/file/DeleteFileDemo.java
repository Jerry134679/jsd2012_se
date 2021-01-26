package file;

import java.io.File;

/**
 * 删除一个文件
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        //将test.txt文件删除
        //在相对路径中./可写可不写，不写默认从./开始
        File file=new File("test.txt");
        if(file.exists()){
            file.delete();
            System.out.println("该文件已删除");
        }else{
            System.out.println("该文件不存在");
        }
    }
}
