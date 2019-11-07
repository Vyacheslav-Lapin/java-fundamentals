package com.epam.courses.java.fundamentals.oop.practice.task3;

import java.util.Objects;

public class Staff {
  private String officeSupplies;
  private Integer price;
  private Integer number;

  public Staff(String officeSupplies, Integer price, Integer number) {
    this.officeSupplies = officeSupplies;
    this.price = price;
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Staff staff = (Staff) o;
    return Objects.equals(officeSupplies, staff.officeSupplies) &&
        Objects.equals(price, staff.price) &&
        Objects.equals(number, staff.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(officeSupplies, price, number);
  }

  @Override
  public String toString() {
    return "Staff{" +
        "officeSupplies='" + officeSupplies + '\'' +
        ", price=" + price +
        ", number=" + number +
        '}';
  }
}
