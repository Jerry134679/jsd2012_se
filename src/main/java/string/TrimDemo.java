package string;

/**
 * String trim()
 * 去除字符串两边的空白字符
 */
public class TrimDemo {
    public static void main(String[] args) {
        //           左侧三个空格，两个tab
        String str = "   hello      ";
        System.out.println(str);
        String trim = str.trim();
        System.out.println(trim);
    }
}
