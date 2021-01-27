package string;

/**
 * 频繁修改字符串性能损耗
 */
public class StringDemo02 {
    public static void main(String[] args) {
        String str="a";
        for(int i=0;i<10000;i++){
            str=str+"a";
        }
    }
}
