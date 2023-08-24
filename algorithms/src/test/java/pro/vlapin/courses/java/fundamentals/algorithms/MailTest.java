package pro.vlapin.courses.java.fundamentals.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static pro.vlapin.courses.java.fundamentals.algorithms.Mail.*;
import static org.assertj.core.api.Assertions.*;

class MailTest {

  @Test
  @DisplayName("mail works correctly")
  void mailWorksCorrectlyTest() {
    assertThat(howMatchToRead(1, 1, 0, 0, 1)).isEqualTo(4);
    assertThat(howMatchToRead(0, 0)).isZero();
  }
}
