package com.epam.courses.java.fundamentals.oop.practice.task7;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FloatSound {

  String sound();

}
