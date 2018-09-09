package com.example.harshith.shoppingcart;

public class Phone {

    private String model;
    private String manufacturer;
    private Integer price;
    private String image;

    public Phone(String model,String manufacturer,int price,String image){
        this.image = image;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Integer getPrice() {
        return price;
    }

}
