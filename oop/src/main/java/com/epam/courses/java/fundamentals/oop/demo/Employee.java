package com.epam.courses.java.fundamentals.oop.demo;

import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
public class Employee extends Person {

  int salary;
}
