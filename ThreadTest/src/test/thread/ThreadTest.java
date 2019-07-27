package test.thread;


import sun.security.krb5.internal.Ticket;

class MyThread extends Thread{

<<<<<<< HEAD
    private int ticket = 200;
=======
    private int ticket = 200000;
>>>>>>> 100754385d8c30384784feb945eeb110acf28ca5

    @Override
    //此方法为每个线程都需要执行的任务
    public void run() {
<<<<<<< HEAD
        for (int i=0;i<200;i++){
=======
        for (int i=0;i<2000;i++){
>>>>>>> 100754385d8c30384784feb945eeb110acf28ca5
//            //需要在判断处上“锁”
//            //this表示当前对象
//            synchronized (this){
//                if(ticket>0){
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"还剩下"+ticket-- +"票");
//                }
//            }
            sellTicket();
        }

    }
    public synchronized void sellTicket(){
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"还剩下"+ticket-- +"票");
        }

    }
}




public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"黄牛A");
        Thread thread2= new Thread(myThread,"黄牛B");
        Thread thread3 = new Thread(myThread,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
