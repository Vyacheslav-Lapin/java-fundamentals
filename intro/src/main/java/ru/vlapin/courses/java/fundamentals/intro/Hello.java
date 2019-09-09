package ru.vlapin.courses.java.fundamentals.epam.intro;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class Hello {

  public void main(String... __) {
    //noinspection unused
    String s = "world!";

//    System.out.println("Hello, $s");
    System.out.println("Hello, " + s);
//    log.info("Hello, $s");
    log.info("Hello, " + s);
  }
}
