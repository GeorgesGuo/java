package com.guo;

public class Person {
    private String pName;
    private int pAge;

    public Person() {
    }

    public Person(String name, int age) {
        this.pName = name;
        this.pAge = age;
    }

    public String getpName() {
        return this.pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpAge() {
        return this.pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public void sayHello() {
        System.out.println("hello nice to meeting you");
    }

    public String toString() {
        return "Person{pName='" + this.pName + '\'' + '}';
    }
}

