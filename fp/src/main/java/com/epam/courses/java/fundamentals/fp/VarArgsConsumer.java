package com.epam.courses.java.fundamentals.fp;

import java.util.function.Consumer;

@FunctionalInterface
public interface VarArgsConsumer<T> extends Consumer<T[]>, VarArgsFunction<T, Object> {

  @Override
  @SuppressWarnings("unchecked")
  void accept(T... ts);

  @Override
  @SuppressWarnings("unchecked")
  default Object apply(T... ts) {
//    default <R> R apply(T... ts) {
    accept(ts);
    return null;
  }

  default <R> VarArgsFunction<T, R> toVarFunction() {
    return ts -> {
      accept(ts);
      return null;
    };
  }
}
