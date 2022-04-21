package com.epam.courses.java.fundamentals.oop.demo.inner;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

/**
 * Методы внутреннего класса имеют прямой доступ ко всем
 * полям и методам внешнего класса
 */
@RequiredArgsConstructor
public class Outer1 {
  String str; // private final
  LocalDate date; // private final

  class Inner {
    public String method() {
      return String.format("str: %s\ndate: %s", str, date);
    }
  }
}
