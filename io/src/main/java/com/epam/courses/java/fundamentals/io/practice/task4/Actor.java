package com.epam.courses.java.fundamentals.io.practice.task4;

import lombok.experimental.NonFinal;

import java.io.Serializable;

public class Actor implements Serializable {

  String name;

  String surname;

  @NonFinal
  int birthYear;

  public Actor(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getBirthYear() {
    return birthYear;
  }
}
