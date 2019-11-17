package com.epam.courses.java.fundamentals.oop.practice.employee.desktop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Office {
  public Office(Employee... employees) {
    Stream.of(employees).forEach(e -> empStat.put(e.getId(), new ArrayList<>()));


  }

  HashMap<Integer, ArrayList<Stationery>> empStat = new HashMap<>();


  public double calculateStationeryCost(Employee employee) {
    ArrayList<Stationery> stationery = empStat.get(employee.getId());
    double totalCost = stationery.stream().mapToDouble(Stationery::price).sum();
    return totalCost;

  }

  public void addStationery(int id, Stationery... newStationeries) {
    ArrayList<Stationery> oldStationeries = empStat.get(id);
    Stream.of(newStationeries).forEach(oldStationeries::add);
  }

  public ArrayList<Stationery> createStarterKit() {
    ArrayList<Stationery> starterKit = new ArrayList<>();
    starterKit.add(new BallPen());
    starterKit.add(new GelPen());
    starterKit.add(new InkPen());
    starterKit.add(new Notebook());
    starterKit.add(new Eraser());
    starterKit.add(new Pencil());
    return starterKit;
  }


}
