package com.epam.courses.java.fundamentals.fp;

import io.vavr.Function0;

public interface Function3<T1, T2, T3, R> extends io.vavr.Function3<T1, T2, T3, R> {

  default Function0<R> supply(T1 t1, T2 t2, T3 t3) {
    return () -> apply(t1, t2, t3);
  }
}
