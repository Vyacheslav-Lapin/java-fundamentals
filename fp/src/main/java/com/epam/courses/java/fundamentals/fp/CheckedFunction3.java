package com.epam.courses.java.fundamentals.fp;

import static com.epam.courses.java.fundamentals.exceptions.Exceptional.sneakyThrow;

import org.jetbrains.annotations.Contract;

public interface CheckedFunction3<T1, T2, T3, R> extends io.vavr.CheckedFunction3<T1, T2, T3, R> {

  @Contract(value = "_ -> param1", pure = true)
  static <T1, T2, T3, R> CheckedFunction3<T1, T2, T3, R> of(CheckedFunction3<T1, T2, T3, R> cf3) {
    return cf3;
  }

  @Contract(value = "_ -> param1", pure = true)
  static <T1, T2, T3, R> CheckedFunction3<T1, T2, T3, R> narrow(CheckedFunction3<? super T1, ? super T2, ? super T3, ? extends R> cf3) {
    //noinspection unchecked
    return (CheckedFunction3<T1, T2, T3, R>) cf3;
  }

  @Override
  default Function3<T1, T2, T3, R> unchecked() {
    return (t1, t2, t3) -> {
      try {
        return apply(t1, t2, t3);
      } catch(Throwable t) {
        return sneakyThrow(t);
      }
    };
  }

  default CheckedFunction0<R> supply(T1 t1, T2 t2, T3 t3) {
    return () -> apply(t1, t2, t3);
  }
}
