package com.guo;

public class Client {
    public static void main(String[] args) {
       SecurityHandler securityHandler = new SecurityHandler();
       IUserManager iUserManager = (IUserManager) securityHandler.proxyInstance(new UserManagerImpl());
       iUserManager.addUser("guo","1234");

    }
}
