package org.example.bkashapp.model;

public class User {
    private String name;
    private String mobile;
    private String pin;
    private String type;

    public User(String name, String mobile, String pin , String type) {
        this.name = name;
        this.mobile = mobile;
        this.pin = pin;
        this.type = type;
    }

    public User(String name, String mobile, String type) {
        this.name = name;
        this.mobile = mobile;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
