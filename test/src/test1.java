


class Singleton{
    //饿汉式单例
    private static Singleton singleton = new Singleton();
    private Singleton(){ }
    public static Singleton getSingleton(){
        return singleton;
    }
}

//最完整的懒汉式单例
class Singleton1{
    //普通懒汉式单例，存在线程安全问题
    private String str;
    private static volatile Singleton1 singleton ;
    private Singleton1(){
        str = "hello";
    }public String getStr() {
        return str;
    }
    public static Singleton1 getSingleton(){
        if(singleton == null){ //single checked
           synchronized (Singleton1.class){
               if(singleton == null) { //double checked
                   singleton = new Singleton1();//
               }
           }
        }
        return singleton;
    }
}



public class test1 {
    private static volatile int num = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i <10 ; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <100 ; j++) {
                        num++;
                    }
                }
            });
            threads[i].start();

        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(num);
    }
}
