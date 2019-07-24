package test.thread;

class Sleep implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+",i ="+i);
                //中断异常
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class SleepTest {
    public static void main(String[] args) {
        Runnable runnable= new Sleep();
        System.out.println();
        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);
        Thread th3 = new Thread(runnable);
        th1.start();
        th2.start();
        th3.start();
        System.out.println("zhuxiancheng");
    }
}
