package com.epam.courses.java.fundamentals.oop.practice.task4;

import com.epam.courses.java.fundamentals.oop.practice.task3.Paper;

public class PaperForNotes extends Paper {

  String name = "paper for notes";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "PaperForNotes{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }

  public PaperForNotes(double price) {
    super(price);
  }
}
