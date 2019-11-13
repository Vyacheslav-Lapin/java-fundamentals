package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private List<StationeryType> stationeryList = new ArrayList<>();

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, List<StationeryType>stationeryList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stationeryList = stationeryList;
    }

    public void addStationery(StationeryType item) {
        if (item == null) {
            System.out.println("Item cannot be null!");
        } else {
            stationeryList.add(item);
        }
    }

    public void updateStationery(StationeryType item) {
        if (item == null) {
            System.out.println("Item cannot be null!");
        } else {
            int index = stationeryList.indexOf(item);
            stationeryList.set(index, item);
        }
    }

    public void deleteStationery(StationeryType item) {
        if (item == null) {
            System.out.println("Item cannot be null!");
        } else {
            stationeryList.remove(item);
        }
    }

    public double getTotalCost() {
        double totalCost = 0.0;

        for (StationeryType item : stationeryList) {
            totalCost += item.getPrice();
        }

        return totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                Objects.equals(stationeryList, employee.stationeryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, stationeryList);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", stationeryList=" + stationeryList +
                '}';
    }
}
