package com.epam.courses.java.fundamentals.oop.demo.myjunit;

import static com.epam.courses.java.fundamentals.oop.annotations.AnnotationUtils.getDeepAnnotation;
import static com.epam.courses.java.fundamentals.oop.annotations.AnnotationUtils.isDeepAnnotationPresent;
import static com.epam.courses.java.fundamentals.oop.annotations.AnnotationUtils.isPseudoNullValue;
import static java.lang.Boolean.*;

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
 * java -jar hw-junit.jar [class1 [class2 [class3...]]]
 * Usage example:
 * java -jar hw-junit.jar ru.vlapin.courses.java.fundamentals.oop.demo.myjunit.hw.TestClass1 ru.vlapin.courses.java.fundamentals.oop.demo.myjunit.hw.TestCless2
 */
@Slf4j
@UtilityClass
public class Assertions {

  @NonFinal
  boolean isFailed;

  @SuppressWarnings("java:S106")
  public void main(String... args) {
    System.out.println(Arrays.stream(args)
                           .flatMap(Assertions::execTestClass)
                           .count());
    //        .forEach(Assertions::printResult);
  }

  private static void printResult(@NotNull Tuple2<Method, Either<Exception, Boolean>> tuple2) {
    getDeepAnnotation(tuple2._1, Test.class).ifPresent(
        test -> log.info("Test {} has {}",
            isPseudoNullValue(test.value()) ? tuple2._1.getName() : test.value(),
            tuple2._2.isRight() ?
                (TRUE.equals(tuple2._2.get()) ? "done." : "failed.") :
                "threw exception: " + tuple2._2.getLeft() + "."));
  }

  @SuppressWarnings("unused")
  public void fail() {
    isFailed = true;
  }

  private boolean getFailedAndClear() {
    boolean result = isFailed;
    isFailed = false;
    return result;
  }

  @SneakyThrows
  private static Stream<Tuple2<Method, Either<Exception, Boolean>>> execTestClass(String className) {

    Class<?> aClass = Class.forName(className);
    Method[] methods = aClass.getMethods();

    // Сначала вызываем все статические методы для инициализации класса теста
    Arrays.stream(methods)
        .filter(method -> Modifier.isStatic(method.getModifiers()))
        .filter(staticMethod -> isDeepAnnotationPresent(staticMethod, BeforeAll.class))
        .peek(staticBeforeAllMethod -> staticBeforeAllMethod.setAccessible(true))
        .map(staticBeforeAllMethod -> CheckedFunction1.narrow(staticBeforeAllMethod::invoke).unchecked())
        .forEach(staticBeforeAllMethod -> staticBeforeAllMethod.apply(null));

    // Для динамических методов аннотированных @Test, выполняем метод initAndRun
    Stream<Tuple2<Method, Either<Exception, Boolean>>> result =
        Arrays.stream(methods)
            .filter(method -> !Modifier.isStatic(method.getModifiers()))
            .filter(dynamicMethod -> isDeepAnnotationPresent(dynamicMethod, Test.class))
            .peek(dynamicTestMethod -> dynamicTestMethod.setAccessible(true))
            .map(dynamicTestMethod -> Tuple.of(dynamicTestMethod, initAndRun(dynamicTestMethod)));

    // В конце вызываем все статические методы для инициализации класса теста
    Arrays.stream(methods)
        .filter(method -> Modifier.isStatic(method.getModifiers()))
        .filter(staticMethod -> isDeepAnnotationPresent(staticMethod, AfterAll.class))
        .peek(staticAfterAllMethod -> staticAfterAllMethod.setAccessible(true))
        .map(staticAfterAllMethod -> CheckedFunction1.narrow(staticAfterAllMethod::invoke).unchecked())
        .forEach(staticAfterAllMethod -> staticAfterAllMethod.apply(null));

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
        .filter(dynamicMethod -> isDeepAnnotationPresent(dynamicMethod, Before.class))
        .map(beforeMethod -> CheckedFunction1.narrow(beforeMethod::invoke).unchecked())
        .forEach(beforeMethod -> beforeMethod.apply(instance));

    try {
      method.invoke(instance);
    } catch (Exception t) {
      return Either.left(t);
    }

    Arrays.stream(methods)
        .filter(method1 -> !Modifier.isStatic(method1.getModifiers()))
        .filter(dynamicMethod -> isDeepAnnotationPresent(dynamicMethod, After.class))
        .map(beforeMethod -> CheckedFunction1.narrow(beforeMethod::invoke).unchecked())
        .forEach(beforeMethod -> beforeMethod.apply(instance));

    return Either.right(getFailedAndClear());
  }
}
