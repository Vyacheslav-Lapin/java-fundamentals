package com.epam.courses.java.fundamentals.oop.demo.records;

import java.time.LocalDate;
import lombok.Value;

@Value
public class Person {

  String firstName;
  String lastName;
  LocalDate dob;

  public static void main(String[] args) {
    System.out.println("person = " + new Person("Вася", "Пупкин", LocalDate.parse("2007-12-03")));
  }
}
