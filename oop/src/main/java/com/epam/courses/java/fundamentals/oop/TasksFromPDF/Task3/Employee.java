package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task3;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    String name;
    List<Stationery> stationeryList = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, List<Stationery> stationeryList) {
        this.name = name;
        this.stationeryList = stationeryList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", stationeryList=" + stationeryList +
                '}';
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Ben", new NovicePack().getStationeryList());
        System.out.println(employee);
    }
}
