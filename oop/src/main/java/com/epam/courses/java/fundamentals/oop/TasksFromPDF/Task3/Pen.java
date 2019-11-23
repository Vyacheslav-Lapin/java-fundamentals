package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task3;

public class Pen extends Stationery {
    private String color;
    private double lineWidth;

    public Pen(int quantity, double price, String color, double lineWidth) {
        super(quantity, price);
        this.color = color;
        this.lineWidth = lineWidth;
    }

    public String getColor() {
        return color;
    }

    public double getLineWidth() {
        return lineWidth;
    }
}
