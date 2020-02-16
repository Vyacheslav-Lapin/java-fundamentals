package com.epam.courses.java.fundamentals.oop.practice.task2;

import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class Pen extends Stuff {

  private int number;
  private typesOfPen typeOfPen;

  public Pen(int number, int price, String name, String company, typesOfPen typeOfPen){
    super(price, company, name);
    this.number = number;
    this.typeOfPen = typeOfPen;
  }

  public int getNumber() {
    return number;
  }

  public typesOfPen getTypeOfPen() {
    return typeOfPen;
  }

  @Override
  public int getPrice() {
    return price;
  }

  @Override
  public String getCompany() {
    return company;
  }

//  @Override
//  public void setPrice(int price) {
//    this.price = price;
//  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, price, company, name, typeOfPen);
  }

  @Override
  @Contract(value = "null -> false", pure = true)
  public boolean equals(Object obj) {
    if(this == obj)
      return true;
    if(obj == null || this.getClass() != obj.getClass())
      return false;
    Pen pen = (Pen)obj;
    return this.number == pen.number
        && this.price == pen.price
        && this.company.equals(pen.company)
        && this.typeOfPen.equals(pen.typeOfPen)
        && this.name.equals(pen.name);
  }

  @Override
  public String toString() {
    return "Pen № " + this.number + " [ name: " + this.name +" price: " + this.price + " company: " + this.company + " type of pen: " +  this.typeOfPen + " ]";
  }
}
