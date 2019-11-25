package com.epam.courses.java.fundamentals.oop.practice.task8;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Boat {
  String color();
}
