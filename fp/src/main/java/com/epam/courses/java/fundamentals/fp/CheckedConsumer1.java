package com.epam.courses.java.fundamentals.fp;

import com.epam.courses.java.fundamentals.exceptions.Exceptional;
import io.vavr.CheckedConsumer;
import java.util.function.Consumer;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface CheckedConsumer1<T> extends Consumer<T> {

  @NotNull
  @Contract(value = "_ -> param1", pure = true)
  static <T> CheckedConsumer1<T> of(@NotNull CheckedConsumer1<T> consumer) {
    return consumer;
  }

  @NotNull
  @SuppressWarnings({"Contract", "unchecked"})
  @Contract(value = "_ -> param1", pure = true)
  static <T> CheckedConsumer1<T> narrow(@NotNull CheckedConsumer1<? extends T> consumer) {
    return (CheckedConsumer1<T>) consumer;
  }

  @SneakyThrows
  @Contract(value = "_, _ -> param1", pure = true)
  static <T> T doWith(T obj, @NotNull CheckedConsumer1<T> consumer) {
    consumer.put(obj);
    return obj;
  }

  @SneakyThrows
  static <T extends AutoCloseable> void doWithAndCleanup(T obj,
                                                         @NotNull CheckedConsumer1<T> cns) {
    try (obj) {
      cns.put(obj);
    }
  }

  static <T> Consumer<T> unchecked(CheckedConsumer1<T> consumer) {
    return of(consumer).unchecked();
  }

  void put(T t) throws Throwable;

  @Override
  @SneakyThrows
  default void accept(@NotNull T t) {
    put(t);
  }

  /**
   * Returns a chained {@code CheckedConsumer} that first executes {@code this.accept(t)}
   * and then {@code after.accept(t)}, for a given {@code t} of type {@code T}.
   *
   * @param after the action that will be executed after this action
   * @return a new {@code CheckedConsumer} that chains {@code this} and {@code after}
   * @throws NullPointerException if {@code after} is null
   */
  default CheckedConsumer<T> andThen(@NotNull CheckedConsumer<? super T> after) {
    return t -> {
      accept(t);
      after.accept(t);
    };
  }

  /**
   * Returns an unchecked consumer that will <em>sneaky throw</em> if an exceptions occurs when applying the function.
   *
   * @return a new Consumer<T> that throws a {@code Throwable}.
   */
  default Consumer<T> unchecked() {
    return value -> {
      try {
        put(value);
      } catch (Throwable t) {
        Exceptional.sneakyThrow(t);
      }
    };
  }
}
