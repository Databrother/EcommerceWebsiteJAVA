package com.ecommerce.orders;
import com.ecommerce.Customer;
import com.ecommerce.Product;
import java.util.ArrayList;
import java.util.UUID;

public class Order {

    private final UUID orderID;
    private final Customer customer;
    private final ArrayList<Product> products;
    private double orderTotal;
    private String orderStatus;

    public Order(Customer customer) {
        this.orderID = UUID.randomUUID();
        this.customer = customer;
        this.products = new ArrayList<>();
        this.orderTotal = 0.0;
        this.orderStatus = "Placed";

    }
    public UUID getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getOrderTotal() {
        return orderTotal;
    }
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }



    public String generateSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order ID: ").append(orderID).append("\n");
        summary.append("Customer: ").append(customer.getName()).append("\n");
        summary.append("Products:\n");
        for (Product product : products) {
            summary.append("- ").append(product.getName()).append(" (").append(product.getPrice()).append(")\n");
        }
        summary.append("Order Total: $").append(String.format("%.2f", orderTotal)).append("\n");
        summary.append("Order Status: ").append(orderStatus).append("\n");
        return summary.toString();
    }
}