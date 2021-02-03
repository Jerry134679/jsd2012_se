package thread;
/**
 * 静态方法上如果使用synchronized修饰，那么该方法一定具有同步效果
 */
public class SyncDemo03 {
    public static void main(String[] args) {
        //静态方法与对象无关，只要静态方法有synchronizes一定具有同步效果
        Thread t1=new Thread(){
            @Override
            public void run() {
                Boo.dosome();
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                Boo.dosome();
            }
        };
        t1.start();
        t2.start();
    }
}
class Boo{
    /*
    静态方法上使用synchronized，同步监视器对象为当前类的类对象(Class实例)
    JVM中每个被加载的类都有且只有一个Class的实例与之对应，静态方法就是锁定该对象。
    Class类对象会在后面反射的知识中介绍
     */
   // public synchronized static void dosome(){//静态方法总是同时进行
    public static void dosome() {
        /*
        使用同步块时，通常指定的也是当前类的类对象，获取方式为类名.class即可
         */
        synchronized (Boo.class) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ":正在执行dosome方法");
                Thread.sleep(5000);
                System.out.println(t.getName() + "：执行dosome方法完毕");
            } catch (InterruptedException e) {
            }
        }
    }
}