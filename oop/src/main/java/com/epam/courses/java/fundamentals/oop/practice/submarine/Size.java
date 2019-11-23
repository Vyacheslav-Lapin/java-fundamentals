package com.epam.courses.java.fundamentals.oop.practice.submarine;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {
  int length();
  int width();
  int depth() default 50;
}
