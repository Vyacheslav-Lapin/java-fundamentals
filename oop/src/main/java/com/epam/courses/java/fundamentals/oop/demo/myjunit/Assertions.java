package com.epam.courses.java.fundamentals.oop.demo.myjunit;

import io.vavr.CheckedFunction1;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import lombok.experimental.NonFinal;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

/**
 * Usage (after compile and package):
 * java -jar otus-hw-junit.jar [class1 [class2 [class3...]]]
 * Usage example:
 * java -jar otus-hw-junit.jar ru.otus.l9.hw.TestClass1 ru.otus.l9.hw.TestCless2
 */
@Slf4j
@UtilityClass
public class Assertions {

  @NonFinal
  private boolean isFailed;

  public void main(String... args) {
    Arrays.stream(args)
        .flatMap(Assertions::execTestClass)
        .forEach(Assertions::printResult);
  }

  private static void printResult(@NotNull Tuple2<Method, Either<Exception, Boolean>> tuple2) {
    log.info("Test {} has {}",
        tuple2._1.getDeclaredAnnotation(Test.class).value(),
        tuple2._2.isRight() ?
            (tuple2._2.get() ? "done." : "failed.") :
            "threw exception: " + tuple2._2.getLeft() + ".");
  }

  @SuppressWarnings("unused")
  public void fail() {
    isFailed = true;
  }

  private boolean getFailedAndClear() {
    boolean result = isFailed;
    isFailed = false;
    return result;
//    try {
//      return isFailed;
//    } finally {
//      isFailed = false;
//    }
  }

  @SneakyThrows
  private static Stream<Tuple2<Method, Either<Exception, Boolean>>> execTestClass(String className) {

    Class<?> aClass = Class.forName(className);
    Method[] methods = aClass.getMethods();

    // Сначала вызываем все статические методы для инициализации класса теста
    Arrays.stream(methods)
        .filter(method -> Modifier.isStatic(method.getModifiers()))
        .filter(method -> method.isAnnotationPresent(BeforeAll.class))
        .peek(method -> method.setAccessible(true))
        .map(method -> CheckedFunction1.narrow(method::invoke).unchecked())
        .forEach(method -> method.apply(null));

    // Для динамических методов аннотированных @Test, выполняем метод initAndRun
    Stream<Tuple2<Method, Either<Exception, Boolean>>> result =
        Arrays.stream(methods)
            .filter(method -> !Modifier.isStatic(method.getModifiers()))
            .filter(method -> method.isAnnotationPresent(Test.class))
            .peek(method -> method.setAccessible(true))
            .map(method -> Tuple.of(method, initAndRun(method)));

    // В конце вызываем все статические методы для инициализации класса теста
    Arrays.stream(methods)
        .filter(method -> Modifier.isStatic(method.getModifiers()))
        .filter(method -> method.isAnnotationPresent(AfterAll.class))
        .peek(method -> method.setAccessible(true))
        .map(method -> CheckedFunction1.narrow(method::invoke).unchecked())
        .forEach(method -> method.apply(null));

    return result;
  }

  /**
   * Not Thread-safe!
   */
  @SneakyThrows
  static Either<Exception, Boolean> initAndRun(@NotNull Method method) {
    Class<?> aClass = method.getDeclaringClass();
    Object instance = aClass.getConstructor().newInstance();
    Method[] methods = aClass.getMethods();

    Arrays.stream(methods)
        .filter(method1 -> !Modifier.isStatic(method1.getModifiers()))
        .filter(dynamicMethod -> dynamicMethod.isAnnotationPresent(Before.class))
        .map(beforeMethod -> CheckedFunction1.narrow(beforeMethod::invoke).unchecked())
        .forEach(beforeMethod -> beforeMethod.apply(instance));

    try {
      method.invoke(instance);
    } catch (Exception t) {
      return Either.left(t);
    }

    Arrays.stream(methods)
        .filter(method1 -> !Modifier.isStatic(method1.getModifiers()))
        .filter(dynamicMethod -> dynamicMethod.isAnnotationPresent(After.class))
        .map(beforeMethod -> CheckedFunction1.narrow(beforeMethod::invoke).unchecked())
        .forEach(beforeMethod -> beforeMethod.apply(instance));

    return Either.right(getFailedAndClear());
  }
}
