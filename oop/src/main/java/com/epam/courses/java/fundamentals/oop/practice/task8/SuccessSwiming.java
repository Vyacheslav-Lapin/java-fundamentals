package com.epam.courses.java.fundamentals.oop.practice.task8;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SuccessSwiming {
  boolean successSwiming() default false;
}
