package test.thread;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object){
            object.wait();
        }
    }
}
