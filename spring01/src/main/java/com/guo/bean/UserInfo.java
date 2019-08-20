package com.guo.bean;

public class UserInfo {
    private String username;

    //IOC
    private Person person;

    public Person getPerson() {
        return person;
    }

    //DI
    public void setPerson(Person person) {
        this.person = person;
    }


    public UserInfo(){



    }    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                '}';
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    }
