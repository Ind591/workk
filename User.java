package com.example.workhithaa;

public class User {
    String name,address,mobile,email,password,s1;

   public User(){

   }
    public User(String name, String address, String mobile, String email, String password,String s1) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.s1 = s1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }
}
