package homework;
import java.io.File;
import java.io.FileFilter;
/**
 * 列出当前目录中所有名字包含s的子项。
 * 使用匿名内部类和lambda两种写法
 * 单词记一记:
 * FileFilter   文件过滤器
 * accept       接受
 */
public class day0302 {
    public static void main(String[] args) {
        File file = new File(".");
        if (file.isDirectory()) {
            FileFilter filter = new FileFilter() {
                public boolean accept(File file) {
                    String name = file.getName();
                    return name.contains("s");
                }
            };
            File[] f = file.listFiles(filter);
            for (int i = 0; i < f.length; i++) {
                System.out.println(f[i].getName());
            }
        }
        //过滤器
//            FileFilter filter=(file)-> {
//                    return file.getName().contains("s");
//                };
//            }

    }
}
