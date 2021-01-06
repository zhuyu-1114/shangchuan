package com.yuntu.entity;

import com.yuntu.annotation.DateFormatVaild;

import java.util.Date;

public class User {
    private String userName;
    private String pwd;
    private String validCode;
    @DateFormatVaild(value = "您输入的日期格式不正确",format={"yyyy-MM-dd","yy-MM-dd","yy MM-dd"})
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String userName, String pwd, String validCode) {
        this.userName = userName;
        this.pwd = pwd;
        this.validCode = validCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }
}
