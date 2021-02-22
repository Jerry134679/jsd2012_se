package thread;

/**
 * sleep方法要求必须出路中断异常。
 * (Thread还提供了其他会导致线程阻塞的方法，很多都要求处理这个异常，情况是一样的)
 *
 * 当一个线程调用sleep方法处于睡眠阻塞的过程中，此时该线程的interrupt方法被调用时，
 * 会中断这个阻塞的过程，此时该方法会抛出中断异常。
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin=new Thread(){
            @Override
            public void run() {
                System.out.println("睡眠");
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    System.out.println("中断");
                }
                System.out.println("醒来");
            }
        };
        Thread huang=new Thread(){
            @Override
            public void run() {
                System.out.println("运行");
                for (int i=0;i<5;i++) {
                    System.out.println("执行"+(i+1)+"次");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("结束");
                lin.interrupt();//中断睡眠
            }
        };
        lin.start();
        huang.start();
    }
}
