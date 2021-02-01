package exception;

/**
 * 异常处理机制中的try-catch
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始");
        try {
        //try语句块用来扩上可能出错的代码片段
        //String str=null;
        /*
        如果 str为null时，当虚拟机执行到下面代码会发现这里存在空指针现象，
        于是虚拟机会实例化一个空指针异常的实例，并将其抛出。抛出后会检查报错的这句话是否被异常处理机制控制
        如果没有则会将该异常抛出到当前方法外面，有调用该方法的代码去解决（这里相当于抛出到main方法外面）
         */
           // String str="";
            String str="asd";
            System.out.println(str.length());
            System.out.println(str.charAt(0));
            System.out.println(Integer.parseInt(str));
            System.out.println("123456");//try语句块报错代码以下的程序都不再执行
            //catch用来捕获try中出现的指针异常并予以解决
        }catch (NullPointerException e){
            System.out.println("空指针异常");
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("数组下标越界");
        }catch (NumberFormatException e){
            System.out.println("数组下标越界");
        }catch(Exception e){
            System.out.println("出错了");
            /*
            catch超类异常的意义：
            当try中某几类异常希望使用相同处理办法时，可以catch这些异常的超类
            在最后一个catch处捕获Exception也可以避免因为一个未处理的异常导致程序中断

            当多个catch的异常之间存在继承关系时，子类型异常要在
            上面先行捕获，超类异常在下，否则编译不通过
             */
        }
        //catch可以定义多个，当try中不同异常有不同的处理方式时可以分别捕获

        System.out.println("结束");
    }
}
