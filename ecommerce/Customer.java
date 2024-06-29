package com.ecommerce;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Customer {
    private final UUID customerID;
    private String name;
    private HashMap<Product, Integer> purchaseCart;

    public Customer(){
    this.name = "";
    this.customerID = UUID.randomUUID();
    this.purchaseCart = new HashMap<>();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchaseCart(HashMap<Product, Integer> chart) {
        this.purchaseCart = chart;
    }

    public String getName() {
        return name;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public HashMap<Product, Integer> getPurchaseCart() {
        return purchaseCart;
    }

    public void addToCart(Product product, int quantity) {
        if (product.getQuantity()< quantity){
            System.out.println("number of left product is "+ product.getQuantity());
        }
        else if (purchaseCart.containsKey(product)) {
            purchaseCart.put(product,purchaseCart.get(product)+quantity);
        } else {
            purchaseCart.put(product,quantity);
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
    public double calculateTotal(){ // boots 1 / caps 2 / shoes 3
        int quantity = 0;
        double price = 0;
        for(Map.Entry<Product,Integer> entry: purchaseCart.entrySet()){
             int getQuantity = entry.getValue();
            double getPrice = entry.getKey().getPrice();
            double totalPerProduct =  getPrice*getQuantity;
            price = totalPerProduct +price;
        }

        return price;
    }
    public void makeOrder(Customer customer, Product product){

    }

}
