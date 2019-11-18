package com.epam.courses.java.fundamentals.fp;

import io.vavr.Function0;
import org.jetbrains.annotations.Contract;

public interface CheckedFunction3<T1, T2, T3, R> extends io.vavr.CheckedFunction3<T1, T2, T3, R> {
  @Contract(value = "_ -> param1", pure = true)
  static <T1, T2, T3, R> CheckedFunction3<T1, T2, T3, R> of(CheckedFunction3<T1, T2, T3, R> cf3) {
    return cf3;
  }

  default Function0<R> supply(T1 t1, T2 t2, T3 t3) {
    return () -> unchecked().apply(t1, t2, t3);
  }
}
