package exception;
/**
 * 异常常见的方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {

        System.out.println("程序开始了");
        try{//ctrl+alt+t快捷键
            String str="abc";
            System.out.println(Integer.parseInt(str));
        }catch(Exception e){
            //向控制台输出异常信息
           e.printStackTrace();
           /*
           获取错误信息，通常给用户提示或者记录日志的时候会使用它。
            */
           String str=e.getMessage();
            System.out.println(str);
        }
        System.out.println("程序结束了");
    }
}