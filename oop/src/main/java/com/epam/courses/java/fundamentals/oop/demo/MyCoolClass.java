package com.epam.courses.java.fundamentals.oop.demo;

public class MyCoolClass implements MyCoolestInterface, MyCoolInterface {

  public static void main(String... __) {
    new MyCoolClass().met();
  }

  @Override
  public void met() {
    MyCoolestInterface.super.met();
  }
}
