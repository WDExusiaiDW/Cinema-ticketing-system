package com.movie;

public class Person {

    private String username;
    private String password;
    private Integer role;//1.管理员 2.经理 3.前台

    public Person(String username, String password, Integer role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Person() {
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
