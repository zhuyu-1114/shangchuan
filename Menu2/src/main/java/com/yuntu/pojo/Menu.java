package com.yuntu.pojo;

public class Menu {
    private int mid;
    private String mname;
    private String material;
    private String process;
    private double price;
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Menu() {
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Menu(String mname, String material, String process, double price) {
        this.mname = mname;
        this.material = material;
        this.process = process;
        this.price = price;
    }

    public Menu(int mid, String mname, String material, String process, double price) {
        this.mid = mid;
        this.mname = mname;
        this.material = material;
        this.process = process;
        this.price = price;
    }
}
