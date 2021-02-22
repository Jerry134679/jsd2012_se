package thread;
/**
 * 互斥锁
 * 当使用synchronized锁定多个代码片段，并且这些同步块指定的同步监视器对象相同时，
 * 这些代码片段之间就是互斥的，多个线程不能同时执行他们
 */
public class SyncDemo04 {
    public static void main(String[] args) {
        Foo foo=new Foo();
        Thread t1=new Thread(){
            @Override
            public void run() {
                foo.methodA();
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                foo.methodB();
            }
        };
        t1.start();
        t2.start();
    }
}
class Foo{
    public synchronized void methodA(){
        try {
            Thread t=Thread.currentThread();
            System.out.println(t.getName()+":正在执行A方法");
            Thread.sleep(2000);
            System.out.println(t.getName()+":A方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //public synchronized void methodB(){
    public synchronized void methodB(){
        synchronized (this) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ":正在执行B方法");
                Thread.sleep(2000);
                System.out.println(t.getName() + ":B方法结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}