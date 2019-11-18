package com.epam.courses.java.fundamentals.oop.practice.task7_8;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SubmarineInformation {
  // Annotation element definitions
  int length() default 0;
  int depth() default 0;
  String color() default "black";
}
