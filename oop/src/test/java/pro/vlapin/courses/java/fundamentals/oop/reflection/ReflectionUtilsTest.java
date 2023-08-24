package pro.vlapin.courses.java.fundamentals.oop.reflection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static pro.vlapin.courses.java.fundamentals.oop.reflection.ReflectionUtils.*;

class ReflectionUtilsTest {

  @Test
  void getTypesFromPackageTest() {
    assertThat(getTypesFromPackage(
        "pro.vlapin.courses.java.fundamentals.oop.reflection"))
        .isNotNull()
        .hasSize(5)
        .containsExactlyInAnyOrder(
            ReflectionUtils.class,
            RecordUtils.class,
            ReflectionUtilsTest.class,
            ProxyUtils.class,
            ListPrototypeProxy.class);
  }
}
