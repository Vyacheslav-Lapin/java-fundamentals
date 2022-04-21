package com.epam.courses.java.fundamentals.oop.demo.lombok;

import lombok.extern.slf4j.Slf4j;

// Решение:
// Как добиться
@Slf4j(topic = "Lorem")
public class Example {

  public Example(@MyAnnotation int __) {
  }

  public void method() {
    log.info("Start...");
    //...
  }
}

