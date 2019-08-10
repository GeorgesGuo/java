package com.guo;

public class UserManagerImplProxy implements IUserManager{
    //对真实对象的引用
    private IUserManager iUserManager;
    public UserManagerImplProxy(IUserManager iUserManager){
        this.iUserManager = iUserManager;
    }
    public void addUser(String username, String password) {
        System.out.println("=====Poxy.addUser=====");

    }

    public void modifyUser(int id, String username, String password){
        System.out.println("=====Poxy.modifyUser=====");

    }
}
