package com.epam.courses.java.fundamentals.io.practice.task1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ByteStreamProcessorTest {

  private static ByteStreamProcessor byteStreamProcessor = new ByteStreamProcessor();
  private static String source = "src/main/resources/RegExpExample.java";

  @BeforeAll
  static void init() throws IOException {
    byteStreamProcessor.readBytesFromFile(source);
    byteStreamProcessor.searchByKeyWords(byteStreamProcessor.getData());
    byteStreamProcessor.countKeyWords(byteStreamProcessor.getProcessedData());
  }

  @Test
  @DisplayName("countKeyWords method works correctly")
  void testCountKeyWords() {
    assertThat(byteStreamProcessor.getKeyWords("int ")).isEqualTo(2);
    assertThat(byteStreamProcessor.getKeyWords("import ")).isEqualTo(4);
    assertThat(byteStreamProcessor.getKeyWords("static ")).isEqualTo(2);
  }
}
