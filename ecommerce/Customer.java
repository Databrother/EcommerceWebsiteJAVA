package com.ecommerce;
import java.util.HashMap;

public class Customer {
    private int customerID;
    private String name;
    private HashMap <String, Integer>  purchaseCart ;

    public void setName(String name){
        this.name= name;
    }
    public void setProductID(int customerID){
        this.customerID= customerID;
    }
    public void setPurchaseCart( HashMap <String, Integer> chart ){
        this.purchaseCart= chart;
    }
    public String getName(){
        return name;
    }
    public int getCustomerID(){
        return customerID;
    }
    public HashMap<String, Integer> getPurchaseCart(){
        return purchaseCart;
    }

    public void addToCart (String product, int quantity){
        if (purchaseCart.containsKey(product)){
            int currentQuantity = purchaseCart.get(product);
            purchaseCart.put(product,currentQuantity + quantity);
        } else {
            purchaseCart.put(product, quantity);
        }
    }
    public void removeFromCart (String product, int quantity){
        if (purchaseCart.containsKey(product)){
            int currentQuantity = purchaseCart.get(product);
            if (currentQuantity <= quantity){
                purchaseCart.remove(product);
            } else {
                purchaseCart.put(product,currentQuantity - quantity);
            }

        } else {
            System.out.println("this product isn't in your chart");
        }
    }
}