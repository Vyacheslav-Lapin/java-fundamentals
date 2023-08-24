package pro.vlapin.courses.java.fundamentals.oop.demo.lombok;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExampleTest {

  @Test
  @SneakyThrows
  @DisplayName("Everything works correctly")
  void everythingWorksCorrectlyTest() {
    assertThat(
        Example.class
            .getConstructors()[0]
            .getParameters()[0]
            .getDeclaredAnnotation(MyAnnotation.class))
        .isNotNull();
  }
}
