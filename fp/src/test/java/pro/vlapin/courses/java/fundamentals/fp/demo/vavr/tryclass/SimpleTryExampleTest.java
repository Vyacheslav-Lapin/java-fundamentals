package pro.vlapin.courses.java.fundamentals.fp.demo.vavr.tryclass;

import io.vavr.control.Try;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleTryExampleTest {

  @Test
  @SneakyThrows
  @DisplayName("Creating Try works correctly")
  void creatingTryWorksCorrectlyTest() {
    Try<String> t1 = Try.of(() -> "foo"); // Success<String>
    Try<String> t2 = Try.of(SimpleTryExample::crashes); // Failure<RuntimeException>
    Try<String> t3 = Try.success("foo"); // Success<String>
    Try<Object> t4 = Try.failure(new RuntimeException("bar")); // Failure<RuntimeException>
  }
}
