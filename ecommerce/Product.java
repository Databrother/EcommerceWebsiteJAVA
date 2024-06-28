package com.ecommerce;

public class Product {
    public int productID;
    public String name;
    public double price;

    public void setName(String name){
        this.name= name;
    }
    public void setProductID(int productID){
        this.productID= productID;
    }
    public void setPrice(double price){
        this.price= price;
    }
    public String getName(){
        return name;
    }
    public int getProductID(){
        return productID;
    }
    public double getPrice(){
        return price;
    }
}
