package doc;

public class Demo01 {
    public static void main(String[] args) {
        int n=0b01101000_11110010_10100110_00001111;
        //      01101000 11110010 10100110 00001111
        //        6   8   f   2    a   6    0   f
        System.out.println(Integer.toBinaryString(0x68f2a60f));
        int m=0b10010010_11110100_01110010_11000110;
        //      10100010 11110100 01110010 11000110
        //        a   2    f   4    7    2   c   6
        System.out.println(Integer.toBinaryString(0xa2f472c6));

    }
}
