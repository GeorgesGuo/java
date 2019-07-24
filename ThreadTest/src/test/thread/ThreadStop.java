package test.thread;

class ThreadShutDown implements Runnable{
    private boolean flag = true;
    public void  setFlag(boolean flag){
        this.flag =flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println(Thread.currentThread().getName()+","+i++);
        }
        System.out.println("线程停止");
    }
}
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        ThreadShutDown threadShutDown = new ThreadShutDown();
        Thread thread = new Thread(threadShutDown);
        thread.start();
        Thread.sleep(1000);
        threadShutDown.setFlag(false);

    }

}
