package com.epam.courses.java.fundamentals.fp;

import com.epam.courses.java.fundamentals.exceptions.Exceptional;
import io.vavr.Tuple2;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;

@FunctionalInterface
public interface CheckedConsumer2<T, U> extends Consumer2<T, U> {

  @Contract(value = "_ -> param1", pure = true)
  static <T, U> CheckedConsumer2<T, U> of(CheckedConsumer2<T, U> checkedBiConsumer) {
    return checkedBiConsumer;
  }

  @Contract(value = "_ -> param1", pure = true)
  static <T, U> CheckedConsumer2<T, U> narrow(CheckedConsumer2<? extends T, ? extends U> checkedBiConsumer) {
    //noinspection unchecked
    return (CheckedConsumer2<T, U>) checkedBiConsumer;
  }

  static <T, U> Consumer2<T, U> unchecked(CheckedConsumer2<T, U> consumer) {
    return of(consumer).unchecked();
  }

  void put(T t, U u) throws Exception;

  @Override
  @SneakyThrows
  default void accept(T t, U u) {
    put(t, u);
  }

  @Override
  default CheckedConsumer1<Tuple2<T, U>> tupled() {
    return tuple2 -> this.put(tuple2._1, tuple2._2);
  }

  /**
   * Returns an unchecked consumer that will <em>sneaky throw</em> if an exceptions occurs when applying the function.
   *
   * @return a new Consumer<T> that throws a {@code Throwable}.
   */
  default Consumer2<T, U> unchecked() {
    return (t, u) -> {
      try {
        accept(t, u);
      } catch (Exception e) {
        Exceptional.sneakyThrow(e);
      }
    };
  }
}
