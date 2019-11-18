package com.epam.courses.java.fundamentals.fp;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface FunctionUtils {

  @NotNull
  @SafeVarargs
  @Contract("_, _ -> param1")
  static <T> T peek(@NotNull T t,
                    @NotNull Consumer<@NotNull T>... consumers) {
    for (val consumer : consumers)
      consumer.accept(t);
    return t;
  }

  @NotNull
  @SafeVarargs
  static <T> T peekFrom(@NotNull Supplier<T> tSupplier,
                        @NotNull Consumer<@NotNull T>... consumers) {
    return peek(tSupplier.get(), consumers);
  }

  @SafeVarargs
  @SneakyThrows
  static <T extends AutoCloseable> void peekAndClose(
      @NotNull T t,
      @NotNull Consumer<@NotNull T>... consumers) {

    try (t) {
      for (val consumer : consumers)
        consumer.accept(t);
    }
  }

  @NotNull
  static <T, R> R map(@NotNull T t,
                      @NotNull Function<@NotNull T, @NotNull R> mapper) {

    return mapper.apply(t);
  }

  @NotNull
  @SneakyThrows
  static <T extends AutoCloseable, R> R mapAndClose(
      @NotNull T t,
      @NotNull Function<@NotNull T, @NotNull R> mapper) {

    try (t) {
      return mapper.apply(t);
    }
  }

  @NotNull
  static <T, R1, R2> R2 map2(@NotNull T t,
                             @NotNull Function<@NotNull T, @NotNull R1> mapper1,
                             @NotNull Function<@NotNull R1, @NotNull R2> mapper2) {

    return mapper2.apply(
        mapper1.apply(t));
  }

  @NotNull
  @SneakyThrows
  static <T extends AutoCloseable, R1, R2> R2 map2AndClose(
      @NotNull T t,
      @NotNull Function<@NotNull T, @NotNull R1> mapper1,
      @NotNull Function<@NotNull R1, @NotNull R2> mapper2) {

    try (t) {
      return mapper2.apply(
          mapper1.apply(t));
    }
  }

  @NotNull
  static <T, R1, R2, R3> R3 map3(@NotNull T t,
                                 @NotNull Function<@NotNull T, @NotNull R1> mapper1,
                                 @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
                                 @NotNull Function<@NotNull R2, @NotNull R3> mapper3) {

    return mapper3.apply(
        mapper2.apply(
            mapper1.apply(t)));
  }

  @NotNull
  @SneakyThrows
  static <T extends AutoCloseable, R1, R2, R3> R3 map3AndClose(
      @NotNull T t,
      @NotNull Function<@NotNull T, @NotNull R1> mapper1,
      @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
      @NotNull Function<@NotNull R2, @NotNull R3> mapper3) {

    try (t) {
      return mapper3.apply(
          mapper2.apply(
              mapper1.apply(t)));
    }
  }

  @NotNull
  static <T, R1, R2, R3, R4> R4 map4(@NotNull T t,
                                     @NotNull Function<@NotNull T, @NotNull R1> mapper1,
                                     @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
                                     @NotNull Function<@NotNull R2, @NotNull R3> mapper3,
                                     @NotNull Function<@NotNull R3, @NotNull R4> mapper4) {

    return mapper4.apply(
        mapper3.apply(
            mapper2.apply(
                mapper1.apply(t))));
  }

  @NotNull
  @SneakyThrows
  static <T extends AutoCloseable, R1, R2, R3, R4> R4 map4AndClose(
      @NotNull T t,
      @NotNull Function<@NotNull T, @NotNull R1> mapper1,
      @NotNull Function<@NotNull R1, @NotNull R2> mapper2,
      @NotNull Function<@NotNull R2, @NotNull R3> mapper3,
      @NotNull Function<@NotNull R3, @NotNull R4> mapper4) {

    try (t) {
      return mapper4.apply(
          mapper3.apply(
              mapper2.apply(
                  mapper1.apply(t))));
    }
  }

  @NotNull
  @Contract("_, _ -> param1")
  static <T> T anAssert(@NotNull T t,
                        @NotNull Predicate<@NotNull T> predicate) {

    return anAssert(t, predicate,
        () -> new RuntimeException(
            "predicate result is false for parameter value " + t));
  }

  @NotNull
  @Contract("_, _, _ -> param1")
  static <T> T anAssert(@NotNull T t,
                        @NotNull Predicate<@NotNull T> predicate,
                        @NotNull Supplier<@NotNull RuntimeException> throwableSupplier) {

    if (predicate.test(t))
      return t;
    else
      throw throwableSupplier.get();
  }

  @NotNull
  @Contract("_, _, _ -> param1")
  static <T> T ifPeek(@NotNull T t,
                      @NotNull Predicate<@NotNull T> predicate,
                      @NotNull Consumer<@NotNull T> consumer) {

    if (predicate.test(t))
      consumer.accept(t);
    return t;
  }

  @NotNull
  @Contract("_, _, _, _ -> param1")
  static <T> T ifElsePeek(@NotNull T t,
                          @NotNull Predicate<@NotNull T> predicate,
                          @NotNull Consumer<@NotNull T> consumerTrue,
                          @NotNull Consumer<@NotNull T> consumerFalse) {

    if (predicate.test(t))
      consumerTrue.accept(t);
    else
      consumerFalse.accept(t);
    return t;
  }

  @NotNull
  @Contract("_, _, _ -> param1")
  static <T> T ifMap(@NotNull T t,
                     @NotNull Predicate<@NotNull T> predicate,
                     @NotNull UnaryOperator<@NotNull T> mapper) {

    return predicate.test(t) ? mapper.apply(t) : t;
  }

  @NotNull
  @Contract("_, _, _ -> param1")
  static <T> T ifNotMap(@NotNull T t,
                        @NotNull Predicate<@NotNull T> predicate,
                        @NotNull UnaryOperator<@NotNull T> mapper) {

    return predicate.test(t) ? t : mapper.apply(t);
  }

  @NotNull
  static <T, R> R ifElseMap(@NotNull T t,
                            @NotNull Predicate<@NotNull T> predicate,
                            @NotNull Function<@NotNull T, @NotNull R> mapperIfTrue,
                            @NotNull Function<@NotNull T, @NotNull R> mapperIfFalse) {

    return predicate.test(t) ? mapperIfTrue.apply(t) : mapperIfFalse.apply(t);
  }


}
