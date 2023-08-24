package pro.vlapin.courses.java.fundamentals.oop.demo.generics;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static pro.vlapin.courses.java.fundamentals.oop.demo.generics.MultipleBoundsGeneric.*;
import static org.assertj.core.api.Assertions.*;

class MultipleBoundsGenericTest {

  @Test
  @SneakyThrows
  @DisplayName("multiple bounds generic works correctly")
  void multipleBoundsGenericWorksCorrectlyTest() {
    assertThat(maximum(3, 4, 5)).isNotNull()
        .isEqualTo(5);

    assertThat(maximum(6.6, 8.8, 7.7)).isNotNull()
        .isEqualTo(8.8);
  }
}
