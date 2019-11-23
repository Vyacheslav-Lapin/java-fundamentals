package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task3;

public class Notepad extends Stationery{
    private int amountOfPages;

    public Notepad(int quantity, double price, int amountOfPages) {
        super(quantity, price);
        this.amountOfPages = amountOfPages;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }
}
