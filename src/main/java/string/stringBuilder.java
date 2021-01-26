package string;
/**
 * StringBuilder修改字符串的效率
 */
public class stringBuilder {
    public static void main(String[] args) {
        String str = "a";
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < 10; i++) {
             builder.append("a");
        }
        str=builder.toString();
        System.out.println(str);
    }
}
