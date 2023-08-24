package pro.vlapin.courses.java.fundamentals.oop.demo.lombok;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetterExampleTest {

  @Test
  @DisplayName("getter usage")
  void getterUsageTest() {
    assertThat(new GetterExample().getX()).isZero();
  }
}
