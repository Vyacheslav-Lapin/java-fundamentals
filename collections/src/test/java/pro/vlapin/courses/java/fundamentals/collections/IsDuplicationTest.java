package pro.vlapin.courses.java.fundamentals.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static pro.vlapin.courses.java.fundamentals.collections.IsDuplication.*;
import static org.assertj.core.api.Assertions.*;

class IsDuplicationTest {

  @Test
  @DisplayName("isDuplicate method works correctly")
  void isDuplicateMethodWorksCorrectlyTest() {
    assertThat(isUnique(1, 2, 3, 4, 5, 6)).isTrue();
    assertThat(isUnique(1, 2, 3, 4, 2)).isFalse();
  }
}
