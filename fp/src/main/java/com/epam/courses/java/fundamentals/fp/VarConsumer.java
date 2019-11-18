package com.epam.courses.java.fundamentals.fp;

import java.util.function.Consumer;

@FunctionalInterface
public interface VarConsumer<T> extends Consumer<T[]>, VarFunction<T, Object> {

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

  default <R> VarFunction<T, R> toVarFunction() {
    return ts -> {
      accept(ts);
      return null;
    };
  }
}
