package com.epam.courses.java.fundamentals.oop.practice.task2;

import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class Ruler extends Stuff {
  private int length;
  private materialForRuler material;

  public Ruler(int price, String company, String name, int length, materialForRuler material){
    super(price, company, name);
    this.length = length;
    this.material = material;
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

  public int getLength() {
    return length;
  }

  public materialForRuler getMaterial() {
    return material;
  }

//  @Override
//  public void setPrice(int price) {
//    this.price = price;
//  }

  @Override
  public int hashCode() {
    return Objects.hash(price, company, name, length, material);
  }

  @Override
  @Contract(value = "null -> false", pure = true)
  public boolean equals(Object obj) {
    if(this == obj)
      return true;
    if(obj == null || this.getClass() != obj.getClass())
      return false;
    Ruler ruler = (Ruler) obj;
    return this.price == ruler.price
        && this.company.equals(ruler.company)
        && this.length == ruler.length
        && this.material == ruler.material
        && this.name.equals(ruler.name);
  }

  @Override
  public String toString() {
    return "Ruler [ name: " + this.name + " price: " + this.price + " company: " + this.company + " length: " + this.length + " material: " + this.material + " ]";
  }
}
