package thread;

/**
 * 线程提供了一个方法
 * void join()
 * 该方法允许一个线程在另一个线程上等待，直到该线程结束后才会结束等待进行自己的后续操作。
 *
 * 例如：
 * A,B是两条线程
 * 当A线程调用了B.join()后，A线程处于阻塞状态，直到B线程结束，A线程才能解除阻塞执行join方法后续代码
 *
 * join方法可以协调线程的同步运行。
 * 同步运行：多个线程执行存在先后顺序执行
 * 异步运行：多个线程各干各的，线程之间本来就是异步运行的。
 */
public class JoinDemo {
    private static boolean isFinish=false;//表示图片是否下载完毕的状态
    public static void main(String[] args) {
        /*
        一个方法的局部内部类中若引用了这个方法的其他局部变量时，这个变量必须声明为final的
        (JDK8之后，可以不再显示使用final关键字修饰这个局部变量，但是如果被该方法的其他局部变量引用时，它仍然是final的)
         */
        //boolean isFinish=false;
        Thread download=new Thread(){
            @Override
            public void run() {
                System.out.println("开始下载图片");
                for (int i=0;i<100;i++){
                    System.out.println("加载"+(i+1)+"%");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("加载完毕");
                isFinish=true;
                //局部内部类访问外部类的变量要求外部的变量为final的，
                // 变量一旦设置为final，值就不能被改变
            }
        };
        Thread show=new Thread(){
            @Override
            public void run() {
                /*
                show线程与download线程启动后是并发运行的。
                其中show线程中显示文字的工作是可以和download同时运行的
                 */
                System.out.println("显示图片");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println("show:文字显示完毕");
                //但是显示图片这件事必须等待download执行完毕（图片下载完毕）再进行
                //阻塞show线程，download执行完毕后工作
                try {
                    System.out.println("show:开始等待");
                    download.join();//使show线程排在download后面等待其完成
                    System.out.println("show:等待下载完成");
                } catch (InterruptedException e) {
                }
                System.out.println("show:开始显示图片");
                if (!isFinish){//如果图片没有加载完毕
                    //当一个异常抛出到线程任务的run方法之外时，这个线程就会结束
                    throw new RuntimeException("图片加载失败");
                }
                System.out.println("图片加载完毕");
            }
        };
        download.start();
        show.start();
    }
}
