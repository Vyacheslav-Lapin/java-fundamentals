package com.epam.courses.java.fundamentals.oop.practice.task2;

import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class Pencil extends Stuff {
  private int number;
  private typesOfPencil typesOfPencil;

  public Pencil(int price, String company, String name, int number, typesOfPencil typesOfPencil) {
    super(price, company, name);
    this.number = number;
    this.typesOfPencil = typesOfPencil;
  }

  public int getNumber() {
    return number;
  }

  public typesOfPencil getTypesOfPencil() {
    return typesOfPencil;
  }

  @Override
  public int getPrice() {
    return price;
  }

  @Override
  public String getCompany() {
    return company;
  }

  @Override
  public String getName() {
    return name;
  }

//  @Override
//  public void setPrice(int price) {
//    this.price = price;
//  }

  @Override
  public int hashCode() {
    return Objects.hash(number, price, company, name, typesOfPencil);
  }

  @Override
  @Contract(value = "null -> false", pure = true)
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || this.getClass() != obj.getClass())
      return false;
    Pencil pencil = (Pencil) obj;
    return (this.price == pencil.price
        && this.typesOfPencil == pencil.typesOfPencil
        && this.number == pencil.number
        && this.company.equals(pencil.company))
        && this.name.equals(pencil.name);
  }

  @Override
  public String toString() {
    return "Pencil № " + this.number + " [ name: " + this.name + " price: " + this.price + " company: " + this.company + " type of pencil: " + this.typesOfPencil + " ]";
  }
}
