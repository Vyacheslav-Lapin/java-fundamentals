package com.epam.courses.java.fundamentals.oop.demo.superbuilder;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Child extends Parent {
  String childName;
  int childAge;
}
