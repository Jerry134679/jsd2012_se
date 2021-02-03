package thread;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 守护线程
 * 守护线程是通过调用setDaemon(boolean on)设置而转变而来的。
 * 因此创建上与普通线程没有区别。主要区别在于结束实际上有一点不同：进程的结束
 * 当java进程中没有任何普通线程运行时，该进程就会结束，此时会杀死所有正在运行的守护线程。
 *
 * 守护线程一般也称为后台线程
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose=new Thread(){
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println("死去");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("咣当！");
            }
        };
        Thread jack=new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("去吧！拜拜");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        rose.start();
        //必须在线程启动之前
        jack.setDaemon(true);
        jack.start();
    }
}