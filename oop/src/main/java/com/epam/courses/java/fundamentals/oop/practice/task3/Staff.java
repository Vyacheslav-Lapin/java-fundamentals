package com.epam.courses.java.fundamentals.oop.practice.task3;


import java.util.Objects;

public class Staff {
  private String name;
  private Integer price;
  private Integer number;


  public Staff(String name, Integer price, Integer number) {
    this.name = name;
    this.price = price;
    this.number = number;
  }

  public String getName() {
    return name;
  }
  public Integer getPrice() {
    return price;
  }
  public Integer getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Staff staff = (Staff) o;
    return Objects.equals(name, staff.name) &&
        Objects.equals(price, staff.price) &&
        Objects.equals(number, staff.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price, number);
  }

  @Override
  public String toString() {
    return "Staff{" +
        "name='" + name + '\'' +
        ", price=" + price +
        ", number=" + number +
        '}' + "\n";
  }
}
