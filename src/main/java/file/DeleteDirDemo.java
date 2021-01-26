package file;

import java.io.File;

/**
 * 删除目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        //将当前目录下的demo目录删除
        File dir=new File("demo");
        if(dir.exists()){
            dir.delete();//只能删除空目录
            System.out.println("目录已删除");
        }else{
            System.out.println("目录不存在");
        }

    }
}
