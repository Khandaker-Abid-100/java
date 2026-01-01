package org.example.bkash3;

public class User {
         private    String mobile ;
         private    String name;
         private   String pin ;
         private   String type ;

    public User(String mobile, String name, String pin, String type) {
        this.mobile = mobile;
        this.name = name;
        this.pin = pin;
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
