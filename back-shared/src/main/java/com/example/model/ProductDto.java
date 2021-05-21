package com.example.model;


import java.util.Random;

public class ProductDto {

    public Long id;

    public String name;

    public String price;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public static ProductDto empty(){
        return new ProductDto();
    }
    public static ProductDto random(){
        Random random = new Random();
        ProductDto dto = new ProductDto();
        dto.setId((long) random.nextInt(20));
        dto.setPrice("Price: " + random.nextInt(10));
        dto.setName("Name: " + random.nextInt(10));

        return dto;
    }
}

