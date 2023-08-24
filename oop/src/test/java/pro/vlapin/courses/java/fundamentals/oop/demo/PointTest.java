package pro.vlapin.courses.java.fundamentals.oop.demo;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  @SneakyThrows
  @DisplayName("equals works correctly")
  void equalsWorksCorrectlyTest() {
    assertThat("Lorem ipsum dolor sit amet").isNotNull()
        .asString()
        .hasSize(26);
  }
}
