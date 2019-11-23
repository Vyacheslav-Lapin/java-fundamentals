package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task3;

import java.util.Objects;

public class Stationery {
    private String name;
    private int quantity;
    private double price;

    public Stationery(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stationery that = (Stationery) o;
        return quantity == that.quantity &&
                Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, price);
    }

    @Override
    public String toString() {
        return "Stationery{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
