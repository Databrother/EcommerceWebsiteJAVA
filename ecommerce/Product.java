package com.ecommerce;

import java.util.UUID;

public class Product {
    private UUID productID;
    private String name;
    private double price;

    private int quantity;

    public Product(String name, double price, int quantity) {
        this.productID = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }
    public Product(){
        this.productID = UUID.randomUUID();

    }

    public Product(String name) {
        this.productID = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
    public void setName(String name){
        this.name= name;
    }
    public void setPrice(double price){
        this.price= price;
    }
    public String getName(){
        return name;
    }
    public UUID getProductID(){
        return productID;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){return quantity;}
    public void setQuantity( int quantity){ this.quantity= quantity;}

}
