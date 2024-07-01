package com.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramInterface {

    private Scanner scanner = new Scanner(System.in);
    private List<Product> availableProducts; // List to store available products

    public ProgramInterface() {
        this.availableProducts = new ArrayList<>();
        // Add  products
        availableProducts.add(new Product("Shirt", 19.99, 10));
        availableProducts.add(new Product("Jeans", 39.99, 5));
        availableProducts.add(new Product("Shoes", 49.99, 8));
        availableProducts.add(new Product("snickers",38.99,10));
    }

    public void displayInterface() {
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);
        System.out.println("Welcome " + name);

        int choice = 0;
        while (choice != 4) {
            System.out.println("\nMenu:");
            System.out.println("1. Browse Products");
            System.out.println("2. View Your Cart");
            System.out.println("3. Confirm Order");
            System.out.println("4. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getProducts(customer);
                    break;
                case 2:
                    getPurchaseCart(customer);
                    break;
                case 3:
                    makeOrder(customer);
                    break;
                case 4:
                    System.out.println("Thank you for using the E-commerce App!");
                    exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void getProducts(Customer customer) {
        if (availableProducts.isEmpty()) {
            System.out.println("There are currently no products available.");
            return;
        }

        System.out.println("\nAvailable Products:");
        for (int i = 0; i < availableProducts.size(); i++) {
            Product product = availableProducts.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " ($" + product.getPrice() + ")");
        }

        System.out.println("Enter product number to add to cart (or 0 to go back):");
        int productChoice = scanner.nextInt();

        if (productChoice > 0 && productChoice <= availableProducts.size()) {
            Product selectedProduct = availableProducts.get(productChoice - 1);
            System.out.println("Enter quantity of " + selectedProduct.getName() + " to add:");
            int quantity = scanner.nextInt();
            customer.addToCart(selectedProduct, quantity);
        } else if (productChoice != 0) {
            System.out.println("Invalid product selection. Please try again.");
        }
    }

    private void getPurchaseCart(Customer customer) {
        customer.getPurchaseCart();
    }

    public void makeOrder(Customer customer) {
        if (customer.purchaseCartIsEmpty()) {
            System.out.println("Your cart is empty. Please add products before confirming the order.");
            return;
        }
        customer.makeOrder(customer);
    }

    private void exit(int status) {
        System.exit(status);
    }
}