package com.yuntu.pojo;

public class Itemtype {
    private int typeid;
    private String typename;

    public Itemtype() {
    }

    public Itemtype(int typeid, String typename) {
        this.typeid = typeid;
        this.typename = typename;
    }

    public Itemtype(String typename) {
        this.typename = typename;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "itemtype{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
