package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task3;

public class Pencil extends Stationery {
    private pencliHardness hardness;
    public enum pencliHardness {
        M2, M, TM, T, T2
    }

    public Pencil(int quantity, double price, pencliHardness hardness) {
        super(quantity, price);
        this.hardness = hardness;
    }

    public pencliHardness getHardness() {
        return hardness;
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "hardness=" + hardness +
                '}';
    }
}
