package thread;

/**
 * 使用匿名内部类的形式完成两种线程
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //第一种  使用匿名内部类
        Thread t1=new Thread(){
            @Override
            public void run() {
               for(int i=0;i<100;i++){
                   System.out.println("你好");
               }
            }
        };
        //第二种  使用匿名内部类
        Runnable r2=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    System.out.println("nihao");
                }
            }
        };
        Thread t2=new Thread();
        t1.start();
        t2.start();
    }
}
