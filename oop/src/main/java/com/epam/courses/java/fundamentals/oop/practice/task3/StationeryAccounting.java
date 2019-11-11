package com.epam.courses.java.fundamentals.oop.practice.task3;

import java.util.*;

public class StationeryAccounting {
  public static void main(String[] args) {
    // Object[] o = new Object[]{new Staff("Ol",100,10),new Staff("pen",10,1),new Staff("Peqw",10,10000)};
    // for (int i = 0; i < 10 ; i++) {
    //   System.out.println(o[(int) (Math.random() * o.length)]);
    // }
    HashMap<Employee, Object> map = new HashMap<>();
    Employee employee = new Employee(0, " Oleg", "admin");
    Employee employee2 = new Employee(1, "Eva", "Worker");
    ArrayList<Staff> arrayList = new ArrayList<>();

    arrayList.add(0, new Staff("Pen", 100, 1));
    arrayList.add(1, new Staff("Oil", 1000, 1));
    arrayList.add(2, new Staff("paper", 10000, 1));
    map.put(employee, arrayList.get(0));
    map.put(employee2, Arrays.asList(arrayList.get(1),
                                     arrayList.get(2),"Full price",
            arrayList.get(1).getPrice() +
            arrayList.get(2).getPrice()));

    System.out.println(map);
    System.out.println();
  }
}
