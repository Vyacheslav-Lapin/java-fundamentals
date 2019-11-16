package com.epam.courses.java.fundamentals.io.practice.task4;


import java.io.Serializable;

class Actor implements Serializable {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Actor{" +
        "name='" + name + '\'' +
        '}';
  }

  Actor(String name) {
    this.name = name;
  }
}
