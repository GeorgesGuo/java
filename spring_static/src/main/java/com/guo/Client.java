package com.guo;

public class Client {
    public static void main(String[] args) {
        IUserManager iUserManager = new UserManagerImplProxy(new UserManagerImpl());
        iUserManager.addUser("guo","123");
    }
}
