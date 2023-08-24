package pro.vlapin.courses.java.fundamentals.intro;

import static org.assertj.core.api.Assertions.*;

import pro.vlapin.courses.java.fundamentals.intro.commons.TestUtils;
import pro.vlapin.courses.java.fundamentals.intro.demo.Hello;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloTest {

  @Test
  @DisplayName("main method works correctly")
  void main() {
    assertThat(TestUtils.fromSystemOutPrintln(Hello::main))
        .endsWith("Hello, world!");
  }
}
