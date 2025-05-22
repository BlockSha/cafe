package com.example.cafe;

public class CoffeeOrder {


    private int quantity;
    private double price;

    // Constructeur
    public CoffeeOrder(double price) {
        this.quantity = 0;
        this.price = price;
    }

    // Méthodes
    public void addCoffee() {
        this.quantity += 1;

    }

    public void RemoveCoffee() {
        if (this.quantity > 0) {
            this.quantity -= 1;
        } else {
            System.out.println("Impossible de retirer un café, la quantité est déjà à zéro.");
        }
    }

    public int getQuantity() {
        return this.quantity;
    }
    public double getPrice() {
        return this.price;
    }
    public double CalculOrderAmount() {
        return this.quantity * this.price;
    }
}
