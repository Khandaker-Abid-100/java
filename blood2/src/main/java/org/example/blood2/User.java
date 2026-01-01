package org.example.blood2;

public class User {
   private String name;
   private String mobile;
   private String password;
   private String cgpa;
   private String age;
    private String bio;
   private String bloodGroup;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User(String name, String mobile, String password, String cgpa, String age,String bio, String bloodGroup) {
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.cgpa = cgpa;
        this.age = age;
        this.bio = bio;
        this.bloodGroup = bloodGroup;
    }

    public User(String name, String mobile, String password) {
        this.name = name;
        this.mobile = mobile;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
