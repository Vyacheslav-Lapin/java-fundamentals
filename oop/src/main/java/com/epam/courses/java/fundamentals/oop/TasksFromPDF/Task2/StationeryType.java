package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task2;

import java.util.Objects;

public class StationeryType {
    private int quantity;
    private double price;


    public StationeryType(String name, int quantity, double price) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationeryType that = (StationeryType) o;
        return quantity == that.quantity &&
                Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, price);
    }

    @Override
    public String toString() {
        return "StationeryType{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
