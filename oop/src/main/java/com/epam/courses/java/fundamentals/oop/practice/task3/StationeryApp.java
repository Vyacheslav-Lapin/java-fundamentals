package com.epam.courses.java.fundamentals.oop.practice.task3;

import java.util.ArrayList;
import java.util.Scanner;

public class StationeryApp {

  public static Employee find(int index, ArrayList<Employee> people) {
    for (Employee e : people) {
      if (e.getId() == index) {
        return e;
      }
    }
    throw new RuntimeException("No such employee");
  }

  public static void main(String[] args) {
    Employee anna = new Employee(1, "Anna", "Ivanova");
    Employee anton = new Employee(2, "Anton", "Sidorov");
    Employee kirill = new Employee(3, "Kirill", "Petrov");

    ArrayList<Employee> people = new ArrayList<>();
    people.add(anna);
    people.add(anton);
    people.add(kirill);

    Calculator calc = new Calculator(120);
    Paper paper = new Paper(5);
    Pen pen = new Pen(15);
    Pencil pencil = new Pencil(12);

    while (true) {
      System.out.println(anna);
      System.out.println(anton);
      System.out.println(kirill);

      System.out.print("Enter add, remove ");
      System.out.print("or calculate and id of employee: ");

      Scanner in = new Scanner(System.in);
      String choice = in.next();
      int id = in.nextInt();
      Employee emp;
      emp = find(id, people);
      switch (choice) {

        case "add":
          System.out.println("What do you want to add? And how many?");
          String statChoice = in.next();
          int statQuantity = in.nextInt();
          switch (statChoice) {
            case "calculator":
              emp.addStationery(calc, statQuantity);
              break;
            case "paper":
              emp.addStationery(paper, statQuantity);
              break;
            case "pen":
              emp.addStationery(pen, statQuantity);
              break;
            case "pencil":
              emp.addStationery(pencil, statQuantity);
              break;
            default:
              System.out.println("We don't have this. Sorry:(");
          }
          System.out.println(emp.getStationeries());
          break;

        case "remove":
          System.out.println("What do you want to remove? And how many?");
          String choiceToRemove = in.next();
          int removeQuantity = in.nextInt();
          switch (choiceToRemove) {
            case "calculator":
              emp.removeStationery(calc, removeQuantity);
              break;
            case "paper":
              emp.removeStationery(paper, removeQuantity);
              break;
            case "pen":
              emp.removeStationery(pen, removeQuantity);
              break;
            case "pencil":
              emp.removeStationery(pencil, removeQuantity);
              break;
            default:
              System.out.println("We don't have this. Sorry:(");
          }
          System.out.println(emp.getStationeries());
          break;

        case "calculate":
          System.out.println("Result is : " + emp.calculatePrice());
          System.out.println();
          break;
      }
    }
  }
}

