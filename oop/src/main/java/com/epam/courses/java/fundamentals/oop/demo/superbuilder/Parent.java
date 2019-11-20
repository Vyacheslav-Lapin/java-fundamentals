package com.epam.courses.java.fundamentals.oop.demo.superbuilder;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Parent {
  String parentName;
  int parentAge;

  public Parent(String parentName, int parentAge){
    this.parentName = parentName;
    this.parentAge = parentAge;
  }

  public String getParentName() {
    return parentName;
  }

  public int getParentAge() {
    return parentAge;
  }
}
