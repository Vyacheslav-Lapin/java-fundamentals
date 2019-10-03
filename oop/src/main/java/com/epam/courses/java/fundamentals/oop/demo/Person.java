package com.epam.courses.java.fundamentals.oop.demo;

import static lombok.AccessLevel.PUBLIC;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

//@Getter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Value
//@Data
@Builder
//@AllArgsConstructor(access = PUBLIC)
@NonFinal
public class Person {

//  @NonFinal
  /*private final*/ String name;
//  @NonFinal
  @Default
  /*private final*/ int age = 16;
//  @NonFinal
  /*private final*/ double height;

    @Singular
//  @NonFinal
  /*private final*/ List<String> contacts;

//  public Person(String name, int age, List<String> contacts, double height) {
//    this.name = name;
//    this.age = age;
//    this.contacts = contacts;
//    this.height = height;
//  }

//  public String getName() {
//    return name;
//  }

//  public int getAge() {
//    return age;
//  }

//  public List<String> getContacts() {
//    return contacts;
//  }

//  public double getHeight() {
//    return height;
//  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    Person person = (Person) o;
//    return age == person.age &&
//               Double.compare(person.height, height) == 0 &&
//               Objects.equals(name, person.name) &&
//               Objects.equals(contacts, person.contacts);
//  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(name, age, contacts, height);
//  }

//  @Override
//  public String toString() {
//    return "Person{" +
//               "name='" + name + '\'' +
//               ", age=" + age +
//               ", contacts=" + contacts +
//               ", height=" + height +
//               '}';
//  }
}
