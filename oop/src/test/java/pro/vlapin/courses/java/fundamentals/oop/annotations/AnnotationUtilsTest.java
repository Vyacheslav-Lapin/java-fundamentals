package pro.vlapin.courses.java.fundamentals.oop.annotations;

import static pro.vlapin.courses.java.fundamentals.oop.annotations.AnnotationUtils.getDeepAnnotation;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Retention;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Retention(RUNTIME)
@interface MyDeepAnnotation {
  String value();
}

@Retention(RUNTIME)
@MyDeepAnnotation("Lorem ipsum dolor sit amet")
@interface MyAnnotation {
}

@MyAnnotation
class B {
}

class AnnotationUtilsTest {

  @Test
  @SneakyThrows
  @DisplayName("Annotation inheritance works correctly")
  void annotationInheritanceWorksCorrectlyTest() {
    Assertions.assertThat(AnnotationUtils.getDeepAnnotation(B.class, MyDeepAnnotation.class))
        .isNotNull()
        .containsInstanceOf(MyDeepAnnotation.class)
        .get()
        .extracting(MyDeepAnnotation::value)
        .isEqualTo("Lorem ipsum dolor sit amet");
  }
}
