package com.guo;

public class UserManagerImpl implements IUserManager{
    public void addUser(String username, String password) {
        System.out.println("=====addUser=====");
    }

    public void modifyUser(int id, String username, String password) {
        System.out.println("=====modifyUser=====");
    }
}
