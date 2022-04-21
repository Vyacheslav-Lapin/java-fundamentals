package com.epam.courses.java.fundamentals.oop.demo.superbuilder;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {

  int salary;
}
