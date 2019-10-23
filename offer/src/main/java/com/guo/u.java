package com.guo;

public class u {
    public static void main(String[] args) {
        Thread thread = new Thread(new  newThread());
        thread.run();
        thread.start();
    }
}
class newThread implements Runnable{
    @Override
    public void run() {
        System.out.println("执行本方法的线程为："+Thread.currentThread().getName());

    }
}
