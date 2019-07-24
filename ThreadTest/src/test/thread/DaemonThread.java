package test.thread;

class DaemonTest implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("当前线程是否为守护线程："
                    + Thread.currentThread().isDaemon());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("当前线程是否为守护线程："
                        + Thread.currentThread().isDaemon());
                System.out.println("当前线程被终止");
                return;
            }
        }

    }
}
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        DaemonTest daemonTest = new DaemonTest();
        Thread thread1 = new Thread(daemonTest);
        Thread thread2 = new Thread(daemonTest);
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread2.interrupt();
        Thread.sleep(5000);
        System.out.println("代码结束...");


    }
}
