package pro.vlapin.courses.java.fundamentals.intro.practice.task2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.vlapin.courses.java.fundamentals.intro.commons.TestUtils;

import static org.assertj.core.api.Assertions.*;

class MinFinderTest {

  @Test
  @Disabled
  @DisplayName("Main method works correctly")
  void mainMethodWorksCorrectlyTest() {
    assertThat(TestUtils.fromSystemOutPrintln(MinFinder::main))
        .isEqualTo("""
            0.25
            0.1111111111111111
            Минимальный индекс: 3.0""");
  }
}
