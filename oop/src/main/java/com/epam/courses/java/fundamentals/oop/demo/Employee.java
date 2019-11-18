package com.epam.courses.java.fundamentals.oop.demo;

import com.epam.courses.java.fundamentals.oop.practice.task2.*;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person{

  private int salary;

  private ArrayList<Stuff> listOfStuff;

  public Employee(String name, int age, double height, int salary){
    super(name, age, height);
    this.salary = salary;
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public int getAge() {
    return super.getAge();
  }

  @Override
  public double getHeight() {
    return super.getHeight();
  }

  @Override
  public List<String> getContacts() {
    return super.getContacts();
  }

  public int getSalary() {
    return salary;
  }

  public void addPen(Pen pen){
    listOfStuff.add(pen);
    System.out.println("Pen is added");
  }

  public void addPaper(Paper paper){
    listOfStuff.add(paper);
    System.out.println("Paper is added");
  }

  public void addPencil(Pencil pencil){
    listOfStuff.add(pencil);
    System.out.println("Pencil is added");
  }

  public void addRuler(Ruler ruler){
    listOfStuff.add(ruler);
    System.out.println("Ruler is added");
  }

  public void showAllStuf(){
    int count = 0;
    for (Stuff stuff : listOfStuff
    ) {
      System.out.print("[" + count + "] ");
      System.out.println(stuff.toString());
      count++;
    }
  }

  public void remove(Stuff stuff){
    listOfStuff.remove(stuff);
  }

  public void remove(int index){
    listOfStuff.remove(index);
  }

  public int getAllStuffPrice(){
    int allPrice = 0;
    for (Stuff stuff : listOfStuff
    ) {
      allPrice+=stuff.getPrice();
    }
    return allPrice;
  }

}
