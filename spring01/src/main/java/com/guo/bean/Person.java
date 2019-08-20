package com.guo.bean;

public class Person {
    //DI
    private String pName;
    public Person(){

    }
//    //构造方法
//    public Person(String name){
//        this.pName =name;
//    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pName='" + pName + '\'' +
                '}';
    }

    public void sayHello(){
        System.out.println("hello nice to meeting you!");
    }
}
