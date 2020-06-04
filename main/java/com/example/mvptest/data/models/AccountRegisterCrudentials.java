package com.example.mvptest.data.models;

public class AccountRegisterCrudentials {
    private String name,username,password;

    public AccountRegisterCrudentials(String name,String username,String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
