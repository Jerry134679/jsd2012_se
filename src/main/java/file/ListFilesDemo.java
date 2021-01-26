package file;
import java.io.File;
import java.util.Scanner;
/**
 * 获取一个目录中所有的子项
 */
public class ListFilesDemo {
    public static void main(String[] args) {
        //获取当前目录中的所有子项输出
//        Scanner scan=new Scanner(System.in);
//        String a=scan.nextLine();
        File dir=new File(".");
        /*
        boolean isFile()
        判断当前File是否为一个文件

        boolean isDirectory()
        判断当前File是否为一个目录
         */
        if(dir.isDirectory()){
            File[]subs=dir.listFiles();
            System.out.println(subs.length);
            for(int i=0;i< subs.length;i++){
                System.out.println(subs[i].getName());
            }
        }
    }
}
