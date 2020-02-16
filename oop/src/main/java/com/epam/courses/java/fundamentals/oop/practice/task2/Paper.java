package com.epam.courses.java.fundamentals.oop.practice.task2;

import java.util.Objects;

public class Paper extends Stuff {
  private int numberOfSheets;

  public Paper(int numberOfSheets, int pricePerSheet, String company, String name){
    super(pricePerSheet, company, name);
    this.numberOfSheets = numberOfSheets;
  }

  public int getNumberOfSheets() {
    return numberOfSheets;
  }

  public int getFullPrice(){
    return numberOfSheets * price;
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

  @Override
  public int hashCode() {
    return Objects.hash(company, name, price, numberOfSheets);
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj)
      return true;
    if(obj == null || this.getClass() != obj.getClass())
      return false;
    Paper paper = (Paper)obj;
    return this.company.equals(paper.company)
        && this.price == paper.price
        && this.numberOfSheets == paper.numberOfSheets
        && this.name.equals(paper.name);
  }

  @Override
  public String toString() {
    return "Papper name: " + name + " [company" + company + " price per sheet: " + price + " pnumber of sheets: " + numberOfSheets + "]";
  }
}
