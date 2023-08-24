package pro.vlapin.courses.java.fundamentals.oop.demo.reflection;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PackageUtilTest {

  @Test
  @SneakyThrows
  @DisplayName("classes method works correctly")
  void classesMethodWorksCorrectlyTest() {
    assertThat(PackageUtil.classes("pro.vlapin.courses.java.fundamentals.oop.demo.reflection"))
        .containsExactlyInAnyOrder(PackageUtil.class, PackageUtilTest.class);
  }
}
