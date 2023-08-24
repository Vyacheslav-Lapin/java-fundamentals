package pro.vlapin.courses.java.fundamentals.oop.demo.lombok;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LombokExtensionMethodExampleTest {

  @Test
  @SneakyThrows
  @DisplayName("\"ExtensionMethod\" annotation works correctly")
  void testExtensionMethod() {
    assertThat(new LombokExtensionMethodExample().useExtensionMethods())
        .isNotNull()
        .isEqualTo("Hello, world!");
  }

  @Test
  @SneakyThrows
  @DisplayName("\"getSortedArray\" method works correctly")
  void testGetSortedArray() {
    assertThat(new LombokExtensionMethodExample().getSortedArray())
        .isNotNull()
        .containsSequence(2, 3, 5, 8);
  }
}
