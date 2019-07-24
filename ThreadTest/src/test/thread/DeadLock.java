package test.thread;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class DeadLock {
    private static Object work = new Object();
    private static Object money = new Object();
    public static void main(String[] args) {
        //方法内部类
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (work){
                    System.out.println("先给钱，后工作");
                    synchronized (money){
                        System.out.println("给钱");
                    }
                }
            }
        });
        Thread boss = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (money) {
                    System.out.println("先干活，再给钱");
                    synchronized (work) {
                        System.out.println("先干活");
                    }
                }
            }
        });
        worker.start();
        boss.start();

    }
}
