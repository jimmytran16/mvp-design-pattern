package com.example.mvptest.data.models;

public class UserCrudentials {
    private String username;
    private String password;

    public UserCrudentials(){ /* Empty Constructor for the User crudentials */
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* GETTER functions for crudentials */
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
