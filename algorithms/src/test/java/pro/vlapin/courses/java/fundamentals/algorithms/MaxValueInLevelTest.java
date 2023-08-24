package pro.vlapin.courses.java.fundamentals.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static pro.vlapin.courses.java.fundamentals.algorithms.MaxValueInLevel.*;

class MaxValueInLevelTest {

  @Test
  @DisplayName("maxLevelValues method works correctly")
  void maxLevelValuesMethodWorksCorrectlyTest() {
    // @formatter:off
    assertThat(maxLevelValues(
        1,
        3,                2,
        5,    3,          null, 9,
        4, 3, null, null,       7, 8,
        2)).isNotNull()
        .containsExactly(1,3,9,8,2);
    // @formatter:on
  }
}
