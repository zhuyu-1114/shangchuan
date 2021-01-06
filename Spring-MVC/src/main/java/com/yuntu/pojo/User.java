package com.yuntu.pojo;

public class User {
    private String userName;
    private String passwork;

    public User() {
    }

    public User(String userName, String passwork) {
        this.userName = userName;
        this.passwork = passwork;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passwork='" + passwork + '\'' +
                '}';
    }
}
