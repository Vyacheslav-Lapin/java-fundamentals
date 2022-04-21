package com.epam.courses.java.fundamentals.fp.demo.vavr.tryclass;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SimpleTryExample {

  public String crashes() {
    throw new RuntimeException("I like to crash");
  }
}
