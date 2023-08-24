package pro.vlapin.courses.java.fundamentals.strings;

import static org.assertj.core.api.Assertions.*;

import lombok.*;
import lombok.experimental.*;
import org.junit.jupiter.api.*;

@ExtensionMethod(StringParser.class)
class StringParserTest {

  @Test
  @SneakyThrows
  @DisplayName("String parser works correctly")
  void stringParserWorksCorrectlyTest() {
    assertThat("2.0 MP".doubleStartsWith()).isNotNull()
        .isEqualTo(2.);
    assertThat("10.0 MP".doubleStartsWith()).isNotNull()
        .isEqualTo(10.);
  }
}
