package com.yuntu.pojo;

public class Product {
    private int id;
    private String name;
    private int price;
    private int stock;
    private String fileName;
    private int typeId;
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", fileName='" + fileName + '\'' +
                ", typeId=" + typeId +
                '}';
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Product(String name, int price, int stock, String fileName, int typeId) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.fileName = fileName;
        this.typeId = typeId;
    }

    public Product(int id, String name, int price, int stock, String fileName, int typeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.fileName = fileName;
        this.typeId = typeId;
    }

    public Product() {
    }
}