package com.epam.courses.java.fundamentals.oop.demo.processor;

@ClassAnnotation
public final class DataClass {
  private final int value;

  public DataClass(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
