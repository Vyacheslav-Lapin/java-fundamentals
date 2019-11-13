package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task3;

public class Folder extends Stationery {
    private String color;

    public Folder(int quantity, double price, String color) {
        super(quantity, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
