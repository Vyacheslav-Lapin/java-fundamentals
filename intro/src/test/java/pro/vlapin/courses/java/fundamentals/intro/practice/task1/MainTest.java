package pro.vlapin.courses.java.fundamentals.intro.practice.task1;

import static org.assertj.core.api.Assertions.*;

import pro.vlapin.courses.java.fundamentals.intro.commons.TestUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  @SneakyThrows
  @DisplayName("example")
  void exampleTest() {
    assertThat(TestUtils.fromLog(Main::main))
        .isEqualTo("logic.method(): I am string in Logic class.");
  }
}
