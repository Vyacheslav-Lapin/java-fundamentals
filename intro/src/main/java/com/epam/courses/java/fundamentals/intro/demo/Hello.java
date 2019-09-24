package com.epam.courses.java.fundamentals.intro.demo;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
@UtilityClass
public class Hello {

  public void main(String... __) {
    //noinspection unused
    val s = "world!";
    log.info("Hello, {}", s); // log.info("Hello, $s");
  }
}
