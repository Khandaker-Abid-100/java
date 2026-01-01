package org.example.demo3.model;

public class User {
    private String mobile;
    private String password;
    private String name;

    public User(String name, String password, String mobile) {
        this.mobile = mobile;
        this.password = password;
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
