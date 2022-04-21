package com.epam.courses.java.fundamentals.intro.practice.task3;

import static org.assertj.core.api.Assertions.*;

import com.epam.courses.java.fundamentals.intro.commons.TestUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TablePrinterTest {

  @Test
  @Disabled
  @SneakyThrows
  @DisplayName("print table works correctly")
  void printTableWorksCorrectlyTest() {
    assertThat(TestUtils.fromSystemOutPrintln(
        () -> new TablePrinter(0, 10, 1)
                  .printTable(11)))
        .isEqualTo("""
            +-------------------------+
            |     x     |     f(x)    |
            +-------------------------+
            | 0.000000000|-3.000000000|
            | 1.000000000|-5.185039863|
            | 2.000000000|-1.842178718|
            | 3.000000000|-3.291006191|
            | 4.000000000|-9.799711455|
            | 5.000000000|-2.351639173|
            | 6.000000000|-3.635859929|
            | 7.000000000| 4.244606616|
            | 8.000000000|-2.699367758|
            | 9.000000000|-4.137313712|
            | 10.000000000|-0.762839056|
            +-------------------------+""");
  }
}
