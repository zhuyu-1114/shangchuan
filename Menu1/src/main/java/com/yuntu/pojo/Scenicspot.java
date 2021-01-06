package com.yuntu.pojo;

import java.util.Date;

public class Scenicspot {
    private int sid;
    private String sname;
    private String describe;
    private String city;
    private Double price;
    private Date createDate;

    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Scenicspot() {
    }

    public Scenicspot(String sname, String describe, String city, Double price, Date createDate) {
        this.sname = sname;
        this.describe = describe;
        this.city = city;
        this.price = price;
        this.createDate = createDate;
    }

    public Scenicspot(int sid, String sname, String describe, String city, Double price, Date createDate) {
        this.sid = sid;
        this.sname = sname;
        this.describe = describe;
        this.city = city;
        this.price = price;
        this.createDate = createDate;
    }
}
