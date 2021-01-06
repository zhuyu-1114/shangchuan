package com.yuntu.pojo;

import java.util.Date;

public class Comment {
    private int cid;
    private int sid;
    private String content;
    private Date createDate;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public Comment(int sid, String content, Date createDate) {
        this.sid = sid;
        this.content = content;
        this.createDate = createDate;
    }

    public Comment(int cid, int sid, String content, Date createDate) {
        this.cid = cid;
        this.sid = sid;
        this.content = content;
        this.createDate = createDate;
    }
}
