package com.yuntu.pojo;

public class Probuct {
    private int id;
    private String name;
    private int price;
    private String filename;

    public Probuct() {
    }

    public Probuct(int id, String name, int price, String filename) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.filename = filename;
    }

    public Probuct(String name, int price, String filename) {
        this.name = name;
        this.price = price;
        this.filename = filename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Probuct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", filename='" + filename + '\'' +
                '}';
    }
}
