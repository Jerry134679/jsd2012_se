package exception;
/**
 * finally块
 * finally块是异常处理机制的最后一块。可以直接跟在try语句块之后后者最后一个catch之后。
 * finally块可以保证只要程序执行到try语句块中，无论try语句块是否抛出异常，finally块都必然执行。
 * 通常我们会将释放资源一类的操作放在finally中确保运行。例如io操作后的关闭
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try{
            String str="123";
            System.out.println(str.length());
            //要执行完finally，方法裁会真正return.
            System.out.println("132456789");
            return;
        }catch(Exception e){
            System.out.println("出错了");
        }finally {
            System.out.println("执行finally代码");
        }
        System.out.println("程序结束");
    }
}
