//package com.epam.courses.java.fundamentals.fp;
//
//import common.exceptions.Exceptional;
//import io.vavr.Tuple2;
//import io.vavr.Tuple3;
//import lombok.SneakyThrows;
//import org.jetbrains.annotations.Contract;
//
//@FunctionalInterface
//public interface CheckedConsumer3<T1, T2, T3> extends Consumer3<T1, T2, T3> {
//
//  @Contract(value = "_ -> param1", pure = true)
//  static <T1, T2, T3> CheckedConsumer3<T1, T2, T3> of(CheckedConsumer3<T1, T2, T3> checkedConsumer3) {
//    return checkedConsumer3;
//  }
//
//  @SuppressWarnings({"Contract", "unchecked"})
//  @Contract(value = "_ -> param1", pure = true)
//  static <T1, T2, T3> CheckedConsumer3<T1, T2, T3> narrow(CheckedConsumer3<? extends T1, ? extends T2, ? extends T3> checkedConsumer3) {
//    return (CheckedConsumer3<T1, T2, T3>) checkedConsumer3;
//  }
//
//  static <T1, T2, T3> Consumer3<T1, T2, T3> unchecked(CheckedConsumer3<T1, T2, T3> consumer) {
//    return of(consumer).unchecked();
//  }
//
//  void put(T1 t1, T2 t2, T3 t3) throws Exception;
//
//  @SneakyThrows
//  default void accept(T1 t1, T2 t2, T3 t3) {
//    put(t1, t2, t3);
//  }
//
//  @Override
//  default CheckedConsumer1<Tuple3<T1, T2, T3>> tupled() {
//    return tuple3 -> this.put(tuple3._1, tuple3._2, tuple3._3);
//  }
//
//  @Override
//  default CheckedConsumer2<Tuple2<T1, T2>, T3> tupled12() {
//    return (tuple12, t3) -> this.put(tuple12._1, tuple12._2, t3);
//  }
//
//  @Override
//  default CheckedConsumer2<T1, Tuple2<T2, T3>> tupled23() {
//    return (t1, tuple23) -> this.put(t1, tuple23._1, tuple23._2);
//  }
//
//  @Override
//  default CheckedConsumer2<Tuple2<T1, T3>, T2> tupled13() {
//    return (tuple13, t2) -> this.put(tuple13._1, t2, tuple13._2);
//  }
//
//  /**
//   * Returns an unchecked consumer that will <em>sneaky throw</em> if an exceptions occurs when applying the function.
//   *
//   * @return a new Consumer<T> that throws a {@code Throwable}.
//   */
//  default Consumer3<T1, T2, T3> unchecked() {
//    return (t1, t2, t3) -> {
//      try {
//        accept(t1, t2, t3);
//      } catch (Exception e) {
//        Exceptional.sneakyThrow(e);
//      }
//    };
//  }
//}
