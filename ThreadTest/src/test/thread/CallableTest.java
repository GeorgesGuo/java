package test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableThread implements Callable <String>{
    private int ticket = 20;
    @Override
    //线程需要执行的任务
    public String call() throws Exception {
        while (ticket>0){
            System.out.println("当前线程为："+Thread.currentThread().getName()+"还剩"+ticket-- +"张票");
        }
        return "票卖光了";
    }

}
public class CallableTest{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //产生Callable对象
        CallableThread callableThread = new CallableThread();
        //产生FutureTask对象
        FutureTask<String> futureTask = new FutureTask<>(callableThread);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());

    }
}
