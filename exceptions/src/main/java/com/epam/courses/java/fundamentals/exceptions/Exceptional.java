package com.epam.courses.java.fundamentals.exceptions;

import com.epam.courses.java.fundamentals.fp.CheckedFunction1;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Exceptional {

  @Contract("_ -> fail")
  @SuppressWarnings("unchecked")
  static <E extends Throwable, T> T sneakyThrow(Throwable e) throws E {
    throw (E) e;
  }

  static <T, R> R callUnchecked(@NotNull CheckedFunction1<T, R> checkedFunction1,
                                T t) {
    return checkedFunction1.unchecked().apply(t);
  }
}
