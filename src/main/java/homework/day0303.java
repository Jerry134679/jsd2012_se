package homework;
import java.io.*;
/**
 * 将当前目录下的所有文件都复制一份，复制的文件命名为:原文件名_cp.后缀
 * 比如原文件为:test.dat
 * 复制后的文件为:test_cp.dat
 */
/**
 * 思路:
 * 分为几部分考虑.
 * 第一个是要获取到当前目录中的所有文件(思考哪个API可以解决)
 * 第二个是获取到的每一个文件都要复制(复制用什么API)
 * 第三个是复制的文件名，如何重新组建xxx_cp.xxx的名字?
 *      这里要将原文件名拆开后想办法拼接_cp.
 */
public class day0303 {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        if (file.isFile()) {
            File[] files = file.listFiles();
            for (int i=0;i<files.length;i++) {
               String f=files[i].getName();
                int former = f.indexOf(".");
                String formername = f.substring(0, former);
                String latername = f.substring(former, f.length());
                String name = formername + "cp_" + latername + files[files.length - 1];
                RandomAccessFile src = new RandomAccessFile(f, "r");
                RandomAccessFile desc = new RandomAccessFile("name", "rw");
                int a;
                while ((a = src.read()) != -1) {
                    desc.write(a);
                }
                src.close();
                desc.close();
            }
        }
    }
}
