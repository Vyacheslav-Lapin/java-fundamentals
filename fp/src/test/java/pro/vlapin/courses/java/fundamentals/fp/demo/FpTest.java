package pro.vlapin.courses.java.fundamentals.fp.demo;

import static pro.vlapin.courses.java.fundamentals.fp.demo.common.LazyNumber.LazyNumber;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FpTest {

  @CsvSource("5,2")
  @ParameterizedTest
  @DisplayName("Correct calculate five plus two")
  void correctCalculateFivePlusTwoTest(int x1, int x2) {
    var five = LazyNumber(x1).plus(x2);
    assertThat(five.intValue()).isEqualTo(7);
    assertThat(five.plus(3).intValue())
        .isNotEqualTo(8)
        .isEqualTo(10);
  }
}

