package pro.vlapin.courses.java.fundamentals.oop.demo.lombok.builder;

import static org.assertj.core.api.Assertions.*;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultExampleTest {

  @Test @DisplayName("Builder Defaults works correctly")
  void builderDefaultsWorksCorrectlyTest() {
    val example = DefaultExample.builder()
        .x(100_555)
        .build();

    assertThat(example).isNotNull()
        .extracting(
            DefaultExample::getX,
            DefaultExample::getS,
            DefaultExample::isB)
        .contains(100_555, "lorem", true);
  }
}
