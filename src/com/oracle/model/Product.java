package com.oracle.model;

public class Product {
    private String name;
    private Double price;
    private Integer num;
    private Integer Id;

    public Product() {
    }

    public Product(String name, Double price, Integer num, Integer id) {
        this.name = name;
        this.price = price;
        this.num = num;
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
