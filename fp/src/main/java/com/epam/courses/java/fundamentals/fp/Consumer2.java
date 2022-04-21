package com.epam.courses.java.fundamentals.fp;

import io.vavr.Tuple2;
import java.util.function.Consumer;
import org.jetbrains.annotations.Contract;

@FunctionalInterface
public interface Consumer2<T, U> extends java.util.function.BiConsumer<T, U> {

  @Contract(value = "_ -> param1", pure = true)
  static <T, U> Consumer2<T, U> of(Consumer2<T, U> consumer2) {
    return consumer2;
  }

  @SuppressWarnings("unchecked")
  @Contract(value = "_ -> param1", pure = true)
  static <T, U> Consumer2<T, U> narrow(Consumer2<? extends T, ? extends U> consumer2) {
    return (Consumer2<T, U>) consumer2;
  }

  default Consumer<U> accept(T t) {
    return u -> accept(t, u);
  }

  default Consumer<T> accept2(U u) {
    return t -> accept(t, u);
  }

  /**
   * @alias for {@link #accept2(U)}
   */
  default Consumer<T> acceptRight(U u) {
    return accept2(u);
  }

  default Consumer<Tuple2<T, U>> tupled() {
    return tuTuple2 -> accept(tuTuple2._1, tuTuple2._2);
  }
}
