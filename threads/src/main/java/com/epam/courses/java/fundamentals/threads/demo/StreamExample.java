package com.epam.courses.java.fundamentals.threads.demo;

import java.util.Arrays;

public class StreamExample {

  public static void main(String... __) {
    Arrays.stream("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        .split(" "))
        .filter(s -> s.startsWith("a"))
        .sorted((o1, o2) -> o2.length() - o1.length())
        .limit(3)
        .reduce((s, s2) -> s + ", " + s2)
        .ifPresent(System.out::println);
  }
}
