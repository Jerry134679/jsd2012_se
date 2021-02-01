package thread;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 线程提供的方法
 * static void sleep(long ms)
 * 该方法可以让运行这个方法的线程处于阻塞状态指定毫秒，超时后，线程会自动回到RUNNABLE状态再次获取时间片并发运行
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        /*
        完成一个倒计时程序，程序启动后要求用户数日一个数字。
        然后从该数字开始每秒递减，到0提示时间到
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入倒计时时间");
        int time=scan.nextInt();
        for (int i = time; i > 0; i--) {
            System.out.println("倒计时" + i + "秒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("时间到");
    }
}

