package com.epam.courses.java.fundamentals.io.practice.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class FileConverterTest {

  private static FileConverter fileConverter = new FileConverter();
  private static String source = "src/main/resources/Text.txt";
  private static String destination = "src/main/resources/ConvertedText.txt";

  @Test
  @DisplayName("readFromFile method works correctly")
  void testReadFromFile() throws IOException {
    assertThat(fileConverter.readFromFile(destination, StandardCharsets.UTF_16)).isEqualTo("Этот текст на кириллице\n");
  }
}

