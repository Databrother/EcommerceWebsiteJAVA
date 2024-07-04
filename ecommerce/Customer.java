package com.ecommerce;
import com.ecommerce.orders.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Customer {
    private final UUID customerID;
    private String name;
    protected HashMap<Product, Integer> purchaseCart;

    public Customer(){
    this.name = "";
    this.customerID = UUID.randomUUID();
    this.purchaseCart = new HashMap<>();

    }

    public Customer(String name) {
        this.customerID = UUID.randomUUID();
        this.name = name;
        this.purchaseCart = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                ", purchaseCart=" + purchaseCart +
                '}';
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

    public void getPurchaseCart() {
    for(Map.Entry<Product, Integer> entry : purchaseCart.entrySet()){
        if(purchaseCart.isEmpty()){
            System.out.println("Your cart is empty.");
        } else {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("you have " + quantity +  " " + product.getName() + " in your cart");

        }

    }

    }


    public void addToCart(Product product, int quantity) {
        if (product.getQuantity()< quantity){ // check if item is not out of stock
            System.out.println("number of left product is "+ product.getQuantity());
        }
        else if (purchaseCart.containsKey(product)) {
            purchaseCart.put(product,purchaseCart.get(product)+quantity);
            System.out.println(purchaseCart.get(product) + " " + product + " have been added successfully");
        } else {
            purchaseCart.put(product,quantity);
            System.out.println(quantity + " " +  product.getName() + " has been added successfully");
        }



    }

    public void removeFromCart(Product product, int quantity) {
        if (purchaseCart.containsKey(product)) {
            int currentQuantity = purchaseCart.get(product);
            if (currentQuantity <= quantity) {
                purchaseCart.remove(product); // removes the product completely from the cart
                System.out.println("the " + product.getName() + " has been removed");
            } else {
                purchaseCart.put( product,quantity - currentQuantity);
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
    public void makeOrder(Customer customer) {
        Order order = new Order(customer);
        for (Map.Entry<Product, Integer> entry : customer.purchaseCart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            order.getProducts().add(product);
            order.setOrderTotal(order.getOrderTotal() + (product.getPrice() * quantity));
        }
        customer.setPurchaseCart(new HashMap<>()); // create a new purchase cart
        order.setOrderStatus("Placed"); // Update order status
        System.out.println("Your order has been placed successfully!");
        System.out.println(order.generateSummary()); // Display order summary
    }

}
