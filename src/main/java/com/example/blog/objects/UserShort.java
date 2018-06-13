package com.example.blog.objects;


public class UserShort {

    private long id;
    private String username;
    private String password;

    public UserShort() {
    }

    public UserShort(String username, String s) {
        id = 1;
        this.username = username;
        password = s;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}