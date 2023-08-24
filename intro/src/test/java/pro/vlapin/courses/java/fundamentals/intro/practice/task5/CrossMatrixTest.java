package pro.vlapin.courses.java.fundamentals.intro.practice.task5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrossMatrixTest {

  @Test
  @Disabled
  @DisplayName("toString method works correctly")
  void testToString() {
    assertThat(new CrossMatrix(7).toString())
        .isEqualTo("""
            1 0 0 0 0 0 1\040
            0 1 0 0 0 1 0\040
            0 0 1 0 1 0 0\040
            0 0 0 1 0 0 0\040
            0 0 1 0 1 0 0\040
            0 1 0 0 0 1 0\040
            1 0 0 0 0 0 1\040
            """);
  }
}
