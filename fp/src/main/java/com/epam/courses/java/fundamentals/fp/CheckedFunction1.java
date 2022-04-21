package com.epam.courses.java.fundamentals.fp;

import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface CheckedFunction1<T, R> extends io.vavr.CheckedFunction1<T, R> {

  @Contract(value = "_ -> param1", pure = true)
  static <T, R> CheckedFunction1<T, R> of(CheckedFunction1<T, R> checkedFunction1) {
    return checkedFunction1;
  }

  @SuppressWarnings("unchecked")
  @Contract(value = "_ -> param1", pure = true)
  static <T, R> CheckedFunction1<T, R> narrow(CheckedFunction1<? extends T, ? extends R> checkedFunction1) {
    return (CheckedFunction1<T, R>) checkedFunction1;
  }

  @SneakyThrows
  static <T extends AutoCloseable, R> R mapAndCleanup(T obj,
                                                      @NotNull CheckedFunction1<T, R> function1) {
    try (obj) {
      return function1.apply(obj);
    }
  }

  default CheckedFunction0<R> supply(T t) {
    return () -> apply(t);
  }
}
