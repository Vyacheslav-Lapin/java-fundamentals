package com.epam.courses.java.fundamentals.oop.demo.inheritance;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

class Animal {
  //...
}

class Cat extends Animal {
  public final void meow() { System.out.println("meow!"); }
}

class Dog extends Animal {
  public final void woof() { System.out.println("woof!"); }
}

public class BookInspector {
  public static void main(String... __) {
    sound(new Cat());
    sound(new Dog());
  }

  @SneakyThrows
  public static void sound(@NotNull Animal animal) {
//    if (animal instanceof Cat cat) {
    if (animal instanceof Cat) {
      Cat cat = (Cat) animal;
      cat.meow();
//    } else if (animal instanceof Dog dog) {
    } else if (animal instanceof Dog) {
      Dog dog = (Dog) animal;
      dog.woof();
    }

    // More conditional statements for different animals
  }
}
