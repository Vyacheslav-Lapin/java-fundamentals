package com.epam.courses.java.fundamentals.intro.practice.task1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String... __) {
    var logic = new Logic();
    System.out.println("logic.method(): " + logic.method());
//    log.info("logic.method(): {}", logic.method());
  }
}
