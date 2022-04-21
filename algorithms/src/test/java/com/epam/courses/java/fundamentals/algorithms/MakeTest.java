package com.epam.courses.java.fundamentals.algorithms;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MakeTest {

  @Test
  @SneakyThrows
  @DisplayName("GetCharCount method works correctly")
  void GetCharCount() {
    System.out.println(Make.getCharCount("asdflksjdflaskdf"));
  }
}
