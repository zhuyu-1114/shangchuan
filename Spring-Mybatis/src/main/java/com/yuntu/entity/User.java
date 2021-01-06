package com.yuntu.entity;

import java.util.Date;

public class User {
    private int u_id;
    private String u_userName;
    private String u_password;
    private String u_imgUrl;
    private Date u_createTime;
    private Date u_updateTime;
    private int u_role;

    public int getU_role() {
        return u_role;
    }

    public void setU_role(int u_role) {
        this.u_role = u_role;
    }

    public User() {

    }

    public User(int u_id, String u_userName, String u_password, String u_imgUrl, Date u_createTime, Date u_updateTime) {
        this.u_id = u_id;
        this.u_userName = u_userName;
        this.u_password = u_password;
        this.u_imgUrl = u_imgUrl;
        this.u_createTime = u_createTime;
        this.u_updateTime = u_updateTime;
    }

    public User(String u_userName, String u_password, String u_imgUrl, Date u_createTime, Date u_updateTime) {
        this.u_userName = u_userName;
        this.u_password = u_password;
        this.u_imgUrl = u_imgUrl;
        this.u_createTime = u_createTime;
        this.u_updateTime = u_updateTime;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_userName() {
        return u_userName;
    }

    public void setU_userName(String u_userName) {
        this.u_userName = u_userName;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_imgUrl() {
        return u_imgUrl;
    }

    public void setU_imgUrl(String u_imgUrl) {
        this.u_imgUrl = u_imgUrl;
    }

    public Date getU_createTime() {
        return u_createTime;
    }

    public void setU_createTime(Date u_createTime) {
        this.u_createTime = u_createTime;
    }

    public Date getU_updateTime() {
        return u_updateTime;
    }

    public void setU_updateTime(Date u_updateTime) {
        this.u_updateTime = u_updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_userName='" + u_userName + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_imgUrl='" + u_imgUrl + '\'' +
//                ", u_createTime=" + u_createTime +
//                ", u_updateTime=" + u_updateTime +
                '}';
    }
}
