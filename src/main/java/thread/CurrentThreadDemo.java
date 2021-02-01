package thread;
/**
 * java中所有的代码都是靠线程运行的，main方法也不例外。
 * 运行main方法的线程是系统创建的并且起名为main我们自己定义的线程如果不指定名字，
 * 默认叫Thread-X,X是一个数字，默认从0开始
 *
 * static Thread currentThread()
 * 线程提供了一个静态方法currentThread,可以获取运行这个方法的线程
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        //获取main方法的线程
        Thread main=Thread.currentThread();
        System.out.println("运行main的线程是"+main);
        doSome();
        //让主线程在创建一条线程，并将其启动，与主线程并发运行
        Thread t=new Thread(){
            @Override
            public void run() {
                //获取到的是自定义线程
                Thread t=Thread.currentThread();
                System.out.println("自定义线程"+t);
                doSome();
                for(int i=0;i<100;i++){
                    System.out.println(t+"进行了"+i+"次");
                }
                System.out.println(t+"线程结束");
            }
        };
        t.start();//t线程一旦start后，该线程的run方法就和main方法下面的代码并行
        for (int i=0;i<100;i++){
            System.out.println(main+"主线程进行了"+i+"次");
        }
        System.out.println("主线程结束");
    }
    public static void doSome(){
        //获取运行doSome方法的线程是
        Thread t=Thread.currentThread();
        System.out.println("运行doSome方法的线程是"+t);
    }

}
