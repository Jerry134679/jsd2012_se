package file;
import java.io.File;

/**
 * java.io.File可以表示硬盘上的一个文件或目录
 * 使用File可以：
 * 1：访问该文件或目录的属性信息（大小，修改日期，可读可写）
 * 2：创建或删除文件和目录
 * 3：访问一个目录的所有子项
 *
 * 但是File不能访问文件的数据
 *
 */
public class FileDemo {
    public static void main(String[] args) {
        /*
        File创建时可以指定路径
        该路径通常使用相对路径，它有更好的跨平台性

        相对路径中的"./"表示当前目录，当前目录具体是哪里要
        当前程序的运行环境而定。在idea或eclipse里运行时
        当前目录就是这个程序所在的项目目录
         */
        File file=new File("./demo.txt");//相对路径；尽量不用绝对路径，跨平台性能不好
        String name=file.getName();
        System.out.println(name);

        long len=file.length();
        System.out.println(len+"字节");
        //是否可读，在属性里设置只读和隐藏
        boolean cr=file.canRead();
        System.out.println("可读"+cr);
        //是否可写
        boolean cw=file.canWrite();
        System.out.println("可写"+cw);
        //是否隐藏
        boolean ih=file.isHidden();
        System.out.println("是否隐藏"+ih);
    }
}
