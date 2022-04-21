package com.epam.courses.java.fundamentals.fp.demo.vavr;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.vavr.control.Option;
import java.util.Optional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class OptionTest {

  @Test
  @SneakyThrows
  @DisplayName("optional")
  void optionalTest() {
    Optional<String> maybeFoo = Optional.of("foo");
    assertThat(maybeFoo).contains("foo");
    assertThat(maybeFoo
                   .map(__ -> (String) null)
                   .map(s -> s.toUpperCase() + "bar"))
        .isNotPresent();
  }

  @Test
  @SneakyThrows
  @DisplayName("option")
  void optionTest() {
    Option<String> maybeFoo = Option.of("foo");
    assertThat(maybeFoo).contains("foo");

    assertThrows(NullPointerException.class,
        () -> maybeFoo
                  .map(__ -> (String) null)
                  .map(s -> s.toUpperCase() + "bar"));

    assertThat(maybeFoo
                   //.map(__ -> (String) null)
                   .flatMap(__ -> Option.of((String) null))
                   .map(s -> s.toUpperCase() + "bar"))
        .isEmpty();
  }
}
