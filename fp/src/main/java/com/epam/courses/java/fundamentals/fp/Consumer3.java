package com.epam.courses.java.fundamentals.fp;

import io.vavr.Tuple2;
import io.vavr.Tuple3;
import java.util.function.Consumer;
import org.jetbrains.annotations.Contract;

/**
 * Consumer3.
 *
 * @author vyacheslavlapin
 */
@FunctionalInterface
public interface Consumer3<T1, T2, T3> {

  @Contract(value = "_ -> param1", pure = true)
  static <T1, T2, T3> Consumer3<T1, T2, T3> of(Consumer3<T1, T2, T3> consumer3) {
    return consumer3;
  }

  @SuppressWarnings({"Contract", "unchecked"})
  @Contract(value = "_ -> param1", pure = true)
  static <T1, T2, T3> Consumer3<T1, T2, T3> narrow(Consumer3<? extends T1, ? extends T2, ? extends T3> consumer3) {
    return (Consumer3<T1, T2, T3>) consumer3;
  }

  void accept(T1 t1, T2 t2, T3 t3);


  default Consumer2<T2, T3> accept(T1 t1) {
    return (t2, t3) -> accept(t1, t2, t3);
  }

  default Consumer<T3> accept(T1 t1, T2 t2) {
    return t3 -> accept(t1, t2, t3);
  }

  default Consumer2<T1, T3> accept2(T2 t2) {
    return (t1, t3) -> accept(t1, t2, t3);
  }

  default Consumer2<T1, T2> accept3(T3 t3) {
    return (t1, t2) -> accept(t1, t2, t3);
  }

  default Consumer<T2> accept13(T1 t1, T3 t3) {
    return t2 -> accept(t1, t2, t3);
  }

  default Consumer<T1> accept23(T2 t2, T3 t3) {
    return t1 -> accept(t1, t2, t3);
  }

  /**
   * @aliasFor {@link #accept3(T3)}
   */
  default Consumer2<T1, T2> acceptRight(T3 t3) {
    return accept3(t3);
  }


  default Consumer<Tuple3<T1, T2, T3>> tupled() {
    return t1T2T3Tuple3 -> accept(t1T2T3Tuple3._1, t1T2T3Tuple3._2, t1T2T3Tuple3._3);
  }

  default Consumer2<Tuple2<T1, T2>, T3> tupled12() {
    return (t1T2Tuple2, t3) -> accept(t1T2Tuple2._1, t1T2Tuple2._2, t3);
  }

  default Consumer2<T1, Tuple2<T2, T3>> tupled23() {
    return (t1, t2T3Tuple2) -> accept(t1, t2T3Tuple2._1, t2T3Tuple2._2);
  }

  default Consumer2<Tuple2<T1, T3>, T2> tupled13() {
    return (t1T3Tuple2, t2) -> accept(t1T3Tuple2._1, t2, t1T3Tuple2._2);
  }
}
