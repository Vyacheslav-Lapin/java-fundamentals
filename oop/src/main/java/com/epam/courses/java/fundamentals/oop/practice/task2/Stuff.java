package com.epam.courses.java.fundamentals.oop.practice.task2;

import lombok.Data;

@Data
public abstract class Stuff {
  protected int price;
  protected String name;
  protected String company;

  public Stuff(int price, String company, String name){
    this.price = price;
    this.company = company;
    this.name = name;
  }

  public int getPrice(){
    return price;
  }

  public String getCompany(){
    return company;
  }

  public String getName() { return name; }

//  public void setPrice(int price) {
//    this.price = price;
//  }
}
