package com.epam.courses.java.fundamentals.oop.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Builder.Default;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;

@Value
@NonFinal
@SuperBuilder(toBuilder = true)
public class Person {

  String name;

  public Person(String name, int age, double height){
    this.name = name;
    this.age = age;
    this.height = height;
    this.contacts = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getHeight() {
    return height;
  }

  public List<String> getContacts() {
    return contacts;
  }

  @Default
  int age = 16;
  double height;

  @Singular
  List<String> contacts;

  @Override
  public int hashCode() {
    return Objects.hash(name,age,contacts,height);
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj)
      return true;
    if(obj == null || this.getClass() != obj.getClass())
      return false;
    Person person = (Person) obj;
    return this.name.equals(person.name)
        && this.age == person.age
        && this.height == person.height
        && this.contacts.equals(person.contacts);
  }
}
