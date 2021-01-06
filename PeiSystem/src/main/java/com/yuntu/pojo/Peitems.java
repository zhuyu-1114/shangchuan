package com.yuntu.pojo;

public class Peitems {
    private int itemid;
    private String itemname;
    private int typeid;
    private int necessary;
    private String ref;
    private double price;
    private String info;
    private Itemtype itemtype;

    public Itemtype getItemtype() {
        return itemtype;
    }

    public void setItemtype(Itemtype itemtype) {
        this.itemtype = itemtype;
    }

    public Peitems() {
    }

    public Peitems(int itemid, String itemname, int typeid, int necessary, String ref, double price, String info) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.typeid = typeid;
        this.necessary = necessary;
        this.ref = ref;
        this.price = price;
        this.info = info;
    }

    public Peitems(String itemname, int typeid, int necessary, String ref, double price, String info) {
        this.itemname = itemname;
        this.typeid = typeid;
        this.necessary = necessary;
        this.ref = ref;
        this.price = price;
        this.info = info;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getNecessary() {
        return necessary;
    }

    public void setNecessary(int necessary) {
        this.necessary = necessary;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "peitems{" +
                "itemid=" + itemid +
                ", itemname='" + itemname + '\'' +
                ", typeid=" + typeid +
                ", necessary=" + necessary +
                ", ref='" + ref + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                '}';
    }
}
