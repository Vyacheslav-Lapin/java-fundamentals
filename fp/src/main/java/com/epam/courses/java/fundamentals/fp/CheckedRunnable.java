//package com.epam.courses.java.fundamentals.fp;
//
//import common.exceptions.Exceptional;
//import org.jetbrains.annotations.Contract;
//
//@FunctionalInterface
//public interface CheckedRunnable extends io.vavr.CheckedRunnable {
//
//  @Contract(value = "_ -> param1", pure = true)
//  static CheckedRunnable of(CheckedRunnable checkedRunnable) {
//    return checkedRunnable;
//  }
//
//  /**
//   * Returns an unchecked function that will <em>sneaky throw</em> if an exceptions occurs when applying the function.
//   *
//   * @return a new Runnable, that throws a {@code Throwable} at runtime
//   */
//  @Override
//  default Runnable unchecked() {
//    return () -> {
//      try {
//        run();
//      } catch (Throwable t) {
//        Exceptional.sneakyThrow(t);
//      }
//    };
//  }
//}
