package com.yuntu.pojo;


import java.util.Date;

public class Comment {
    private int cid;
    private int mid;
    private String content;
    private Date createDate;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Comment() {
    }

    public Comment(int mid, String content, Date createDate) {
        this.mid = mid;
        this.content = content;
        this.createDate = createDate;
    }

    public Comment(int cid, int mid, String content, Date createDate) {
        this.cid = cid;
        this.mid = mid;
        this.content = content;
        this.createDate = createDate;
    }
}
