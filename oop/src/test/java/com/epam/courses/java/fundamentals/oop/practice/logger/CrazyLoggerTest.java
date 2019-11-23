package com.epam.courses.java.fundamentals.oop.practice.logger;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrazyLoggerTest {
  CrazyLogger logger = new CrazyLogger();

  CrazyLoggerTest() {
    logger.log("Good morning!");
    logger.log("Good evening!");
    logger.log("Bye!");
  }

  @Test
  void searchTest() {
    List<String> actual = logger.search("Good");
    List<String> expected = List.of("Good morning!", "Good evening!");

    assertEquals(actual.size(), expected.size());
    for (int i = 0; i < actual.size(); i++) {
      String actualEntry = actual.get(i);
      String expectedEntry = expected.get(i);
      assertTrue(actualEntry.contains(expectedEntry));
    }
  }
}

