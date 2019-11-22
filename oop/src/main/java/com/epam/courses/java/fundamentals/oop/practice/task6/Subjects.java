package com.epam.courses.java.fundamentals.oop.practice.task6;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Subjects {
  COMPUTER_SCIENCE(Double.class),
  SOFTWARE_TESTING(Double.class),
  WEB_TECHNOLOGY(Double.class),
  ENGLISH(Integer.class);

  Class<? extends Number> markType;
}
