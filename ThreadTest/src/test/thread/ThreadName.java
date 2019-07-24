package test.thread;


class  NameThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+",i=" +i);
        }
    }
}

public class ThreadName {
    public static void main(String[] args) {
        //向上转型
        Runnable runnable = new NameThread();
        Thread thread1 = new Thread(runnable,"线程A");
        Thread thread2 = new Thread(runnable);
        thread2.setName("线程B");
        thread1.start();
        thread2.start();
    }
}
