package com.epam.courses.java.fundamentals.oop;

import io.vavr.CheckedFunction1;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface AnnotationUtils {

  @NotNull
  static <T extends Annotation> Optional<T> getDeepAnnotation(@NotNull Class<?> targetClass,
                                                              @NotNull Class<T> annotationClass) {
    return getDeepAnnotation(annotationClass, targetClass.getAnnotations());
  }

  /**
   * Works for methods and constructors
   */
  @NotNull
  static <T extends Annotation> Optional<T> getDeepAnnotation(@NotNull Executable target,
                                                              @NotNull Class<T> annotationClass) {
    return getDeepAnnotation(annotationClass, target.getAnnotations());
  }

  @NotNull
  static <T extends Annotation> Optional<T> getDeepAnnotation(@NotNull Parameter target,
                                                              @NotNull Class<T> annotationClass) {
    return getDeepAnnotation(annotationClass, target.getAnnotations());
  }

  @NotNull
  @Contract(pure = true)
  @SuppressWarnings("unchecked")
  static <T extends Annotation> Optional<T> getDeepAnnotation(@NotNull Class<T> annotationClass,
                                                              @NotNull Annotation... annotations) {
    //noinspection unchecked
    return (Optional<T>) deepAnnotations(Arrays.stream(annotations))
                             .filter(annotation -> annotation.annotationType().equals(annotationClass))
                             .findFirst();
  }

  @NotNull
  @Contract(pure = true)
  static Stream<Annotation> deepAnnotations(@NotNull Stream<Annotation> annotations) {
    return annotations
               .flatMap(annotation -> Stream.concat(
                   Stream.of(annotation),
                   deepAnnotations(
                       Stream.of(annotation.annotationType().getAnnotations())
                           .filter(annotation1 ->
                                       !annotation1.annotationType().getPackageName().equals("java.lang.annotation")))))
               .distinct();
  }

  @Contract(pure = true)
  static @NotNull <T extends Annotation> T wrapAnnotationWithAliasForFunctionality(@NotNull T annotation) {

    Class<? extends Annotation> annotationType = annotation.annotationType();

    //noinspection unchecked
    return (T) Proxy.newProxyInstance(
        AnnotationUtils.class.getClassLoader(),
        new Class[]{annotationType},
        (__, method, args) -> {

          Method realMethod = annotationType
                                  .getMethod(method.getName(), method.getParameterTypes());

          Object result = realMethod.invoke(annotation, args);

          if (!method.getDeclaringClass().equals(annotationType)
                  || !isPseudoNullValue(method.getReturnType(), result))
            return result;

          return Optional.ofNullable(realMethod.getDeclaredAnnotation(AliasFor.class))
                     .map(AliasFor::value)
                     .map(CheckedFunction1.<String, Method>narrow(annotationType::getMethod).unchecked())
                     .map(CheckedFunction1.<Method, Object>narrow(method1 -> method1.invoke(annotation)).unchecked())
                     .orElse(result);
        });
  }

  @SneakyThrows
  @Contract(pure = true)
  static boolean isPseudoNullValue(@NotNull Class<?> type, @NotNull Object result) {
    if (type.equals(String.class))
      return result.equals("");
    if (type.isArray())
      return Array.getLength(result) == 0;
    if (type.equals(Class.class))
      return result.equals(Object.class);
    if (!type.isPrimitive())
      return false; //enum - always false

    if (type.equals(int.class))
      return ((int) result) == 0;
    if (type.equals(long.class))
      return ((long) result) == 0L;
    if (type.equals(double.class))
      return ((double) result) == 0.0;
    if (type.equals(float.class))
      return ((float) result) == 0.0f;
    if (type.equals(short.class))
      return ((short) result) == (short) 0;
    if (type.equals(byte.class))
      return ((byte) result) == (byte) 0;
    if (type.equals(char.class))
      return ((char) result) == '\0';
    //    if (type.equals(boolean.class))
    return !((boolean) result);
  }

  static Stream<Tuple2<Class<Annotation>, Annotation>> getDeepAnnotations(@NotNull Class<?> targetClass,
                                                                          @NotNull Class<? extends Annotation> annotationClass) {
    List<? extends Annotation> annotations = new ArrayList<>();

    // TODO: 2019-02-08 доделать
//    for (Annotation annotation : targetClass.getAnnotations()) {
//      if
//    }

    //noinspection unchecked
    return annotations.stream()
             .map(annotation -> Tuple.of((Class<Annotation>) annotation.getClass(), annotation));
  }
}
