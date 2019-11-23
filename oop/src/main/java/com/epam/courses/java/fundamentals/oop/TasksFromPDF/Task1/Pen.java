package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task1;

import java.util.Objects;

public class Pen {
    private String name;
    private String color;
    private boolean isEmpty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return isEmpty == pen.isEmpty &&
                name.equals(pen.name) &&
                color.equals(pen.color);
    }

    @Override
    public String toString() {
        return "Pen{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", isEmpty=" + isEmpty +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
}
