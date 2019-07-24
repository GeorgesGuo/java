package test.thread;

public class ThreadTest1 implements Runnable {
    private int ticket = 20;
    @Override
    public void run() {
        while (ticket>0){
            System.out.println("当前线程为："+Thread.currentThread().getName()
                    +"剩余票数为："+ticket--);
        }

    }

    public static void main(String[] args) {
        ThreadTest1 mt2 = new ThreadTest1();
        Thread thread1 = new Thread(mt2);
        Thread thread2 = new Thread(mt2);
        Thread thread3 = new Thread(mt2);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
