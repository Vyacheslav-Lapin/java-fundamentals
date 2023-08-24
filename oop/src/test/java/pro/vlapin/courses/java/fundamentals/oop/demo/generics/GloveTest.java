package pro.vlapin.courses.java.fundamentals.oop.demo.generics;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GloveTest {

  @Test
  @SneakyThrows
  @DisplayName("Glove works correctly")
  void gloveWorksCorrectlyTest() {
    final var glove = new Glove();
//    final var glove = new Glove<String>();
    final var s = "Lorem ipsum dolor sit amet";
    glove.take(s);
    final var s1 = glove.get(); // String
    assertThat(s1).isNotNull().isSameAs(s);
  }
}
