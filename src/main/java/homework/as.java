package homework;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
/**
 * 用户登录功能
 * 程序启动后，要求用户输入用户名和密码
 * 然后去user.dat文件中比对
 * 成功则输出:登录成功
 * 失败则输出:登录失败，用户名或密码不正确
 * 登录失败的条件:用户名输入正确但是密码不正确，或者用户名输入不正确(user.dat文件中没有此人)
 */
public class as {
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        System.out.println("输入用户名");
        String usersname=scan.nextLine();
        System.out.println("输入密码");
        String password=scan.nextLine();
        RandomAccessFile raf=new RandomAccessFile("user.dat","r");

        for(int i=0;i<raf.length();i++){

            byte[]data=new byte[32];
            raf.read(data);
            String name=new String(data,"UTF-8").trim();

            data=new byte[32];
            raf.read(data);
            String word=new String(data,"UTF-8").trim();
            if(usersname.equals(name) ){
                if(password.equals(word)){
                    System.out.println("输入正确");
                }
                break;
            }
        }
        raf.close();
    }
}