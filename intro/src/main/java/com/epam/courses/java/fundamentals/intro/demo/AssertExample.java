package com.epam.courses.java.fundamentals.intro.demo;

public class AssertExample {

  public static void main(String[] args) {
    assertExample(5, "qwerty"); // OK
    assertExample(-1, ""); // throw new AssertionError()
    assertExample2(6); // throw new AssertionException("d must be later then or equals 5!")
  }

  private static void assertExample2(int d) {
    assert d <= 5 : "d must be later then or equals 5!";
    //...
  }

  private static void assertExample(int d, String s) {
    assert d >= 0 && d <= s.length();
    //...
  }
}
