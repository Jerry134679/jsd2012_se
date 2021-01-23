package string;

/**
 * static String valueOf(XXX xxx)
 * String提供了一组重载的静态方法：valueOf,作用是将java中其他类型转换为String
 * 最常使用于将基本类型转换为字符串
 */
public class ValueOfDemo {
    public static void main(String[] args) {
        int i = 123;
        String str = String.valueOf(i);
        System.out.println(str);

        double dou = 123.123;
        String str2 = String.valueOf(dou);
        System.out.println(dou);

        boolean boo = true;
        String str3 = String.valueOf(boo);
        System.out.println(str3);

        String s3 = i+"";
        System.out.println(s3);
    }
}
