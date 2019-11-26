package com.epam.courses.java.fundamentals.oop.demo.superbuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Child extends Parent {
  String childName;
  int childAge;

  public Child(String parentName, int parentAge, String childName, int childAge){
    super(parentName,parentAge);
    this.childName = childName;
    this.childAge = childAge;
  }

  public String getChildName() {
    return childName;
  }

  public int getChildAge() {
    return childAge;
  }

  @Override
  public String getParentName() {
    return super.getParentName();
  }

  @Override
  public int getParentAge() {
    return super.getParentAge();
  }
}
