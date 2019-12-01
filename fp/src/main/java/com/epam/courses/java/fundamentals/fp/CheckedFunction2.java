package com.epam.courses.java.fundamentals.fp;

public interface CheckedFunction2<T1, T2, R> extends io.vavr.CheckedFunction2<T1, T2, R> {

  static <T1, T2, R> CheckedFunction2<T1, T2, R> of(CheckedFunction2<T1, T2, R> methodReference) {
    return methodReference;
  }

  default CheckedFunction1<T1, R> apply2(T2 t2) {
    return t1 -> apply(t1, t2);
  }
}
