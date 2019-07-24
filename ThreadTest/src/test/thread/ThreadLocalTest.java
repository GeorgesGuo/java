package test.thread;

public class ThreadLocalTest {
    private static String commStr;
    private static ThreadLocal<String> threadLocalStr = new ThreadLocal<>();
    public static void main(String[] args) {
        //主线程
        commStr = "main-commStr";
        threadLocalStr.set("main-ThreadLocal");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr = "thread0-commStr";
                threadLocalStr.set("thread0-ThreadLocal");
            }
        });
        thread.start();

        System.out.println(commStr);
        System.out.println(threadLocalStr.get());
    }
}
