package com.epam.courses.java.fundamentals.oop.demo.lombok;

public class GetterSetterExample {

  private int age = 10;

  private String name;

  @Override
  public String toString() {
    return "GetterSetterExample{" +
               "age=" + age +
               ", name='" + name + '\'' +
               '}';
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  protected void setName(String name) {
    this.name = name;
  }
}
