package com.epam.courses.java.fundamentals.strings.practice.task1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrazyLoggerTest {

  private static CrazyLogger crazyLogger = new CrazyLogger();

  @BeforeAll
  static void init() {
    crazyLogger.addToLog("WARNING message one");
    crazyLogger.addToLog("INFO message one");
    crazyLogger.addToLog("ERROR message one");
  }

  @Test
  @DisplayName("searchByString method works correctly")
  void testSearchByString() {
    assertThat(crazyLogger.searchByString("ERROR")).contains("ERROR message one");
    assertThat(crazyLogger.searchByString("two")).isEqualTo("[]");
  }
}
