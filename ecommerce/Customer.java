package com.ecommerce;
import java.util.HashMap;
import java.util.Map;


public class Customer {
    private int customerID;
    private String name;
    private HashMap<Product, Integer> purchaseCart;

    public void setName(String name) {
        this.name = name;
    }

    public void setProductID(int customerID) {
        this.customerID = customerID;
    }

    public void setPurchaseCart(HashMap<Product, Integer> chart) {
        this.purchaseCart = chart;
    }

    public String getName() {
        return name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public HashMap<Product, Integer> getPurchaseCart() {
        return purchaseCart;
    }

    public void addToCart(Product product, int quantity) {
        if (product.getQuantity()< quantity){
            System.out.println("number of left product is "+ product.getQuantity());
        }
        if (purchaseCart.containsKey(product)) {
            product.quantity += quantity;
        }


    }

    public void removeFromCart(Product product, int quantity) {
        if (purchaseCart.containsKey(product)) {
            int currentQuantity = product.getQuantity();
            if (currentQuantity <= quantity) {
                purchaseCart.remove(product);
            } else {
                product.setQuantity(quantity - currentQuantity);
            }

        } else {
            System.out.println("this product isn't in your chart");
        }
    }
    public void calculateTotal(Product product ){ // boots 1 / caps 2 / shoes 3
        int quantity = 0;
        double price = 0;
        for(Map.Entry<Product,Integer> entry: purchaseCart.entrySet()){
             int getQuantity = entry.getKey().getQuantity();
            quantity = getQuantity + quantity;
            double getPrice = entry.getKey().getPrice();
            price = getPrice + price;
        }
        double totalPrice = quantity * product.price;
    }
    public void makeOrder(Customer customer, Product product){

    }

}
