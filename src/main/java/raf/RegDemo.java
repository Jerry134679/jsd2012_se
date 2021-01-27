package raf;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 用户注册
 * 程序启动后要求用户顺序输入用户名，密码，昵称和年龄
 * 然后将该记录写入文件user.dat中保存
 *
 * 每条记录占用固定的100字节，用户名32字节String，密码32字节String，昵称32字节String，年龄4字节int
 */
public class RegDemo {
    public static void main(String[] args) throws IOException {
        Scanner scan =new Scanner(System.in);
        System.out.println("欢迎注册");
        System.out.println("请输入用户名");
        String username=scan.nextLine();
        System.out.println("请输入密码");
        String password=scan.nextLine();
        System.out.println("请输入昵称");
        String nickname=scan.nextLine();
        System.out.println("请输入年龄");
        int age=scan.nextInt();

        RandomAccessFile raf=new RandomAccessFile("user.dat","rw");

        //将指针移动到文件末尾，以便追加
        raf.seek(raf.length());

        //写用户名
        byte[]data=username.getBytes("UTF-8");
        data= Arrays.copyOf(data,32);
        raf.write(data);

        //写密码
        data=password.getBytes("UTF-8");
        data= Arrays.copyOf(data,32);
        raf.write(data);

        //写昵称
        data=nickname.getBytes("UTF-8");
        data= Arrays.copyOf(data,32);
        raf.write(data);

        //写年龄
        raf.writeInt(age);

        System.out.println("注册完毕");
        raf.close();
    }
}
