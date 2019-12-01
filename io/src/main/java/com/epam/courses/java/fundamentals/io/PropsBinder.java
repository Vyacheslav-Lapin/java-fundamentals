package com.epam.courses.java.fundamentals.io;

import io.vavr.Function1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;
import java.util.function.UnaryOperator;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;

public interface PropsBinder {

  @NotNull
  static <T> T from(Class<T> tClass) {
    return from(tClass.getSimpleName(), tClass);
  }

  @NotNull
  static <T> T from(String propertiesFileName, Class<T> tClass) {
    return from(
        parseProperties(propertiesFileName),
        getMaxArgsCountConstructor(tClass));
  }

  @NotNull
  static <T> T from(@NotNull String propertiesFileName,
                    @NotNull Constructor<T> constructor) {
    return from(parseProperties(propertiesFileName), constructor);
  }

  @NotNull
  @SneakyThrows
  static <T> T from(Function1<String, String> getProperty, Class<T> tClass) {
    return from(getProperty, getMaxArgsCountConstructor(tClass));
  }

  @NotNull
  @SneakyThrows
  static <T> T from(@NotNull Function1<String, String> getProperty,
                    @NotNull Constructor<T> constructor) {
    return constructor.newInstance(
        Arrays.stream(constructor.getParameters())
            .map(parameter -> resolveParameter(getProperty, parameter))
            .toArray());
  }

  @NotNull
  static Function1<String, String> parseProperties(String propertiesFileName) {
    val properties = new Properties();
    InputStreamUtils.withFileInputStream(propertiesFileName + ".properties", properties::load);
    return properties::getProperty;
  }

  @SuppressWarnings("unchecked")
  @NotNull
  static <T> Constructor<T> getMaxArgsCountConstructor(@NotNull Class<T> tClass) {
    return (Constructor<T>) Arrays.stream(tClass.getConstructors())
                                .max(Comparator.comparingInt(Constructor::getParameterCount))
                                .orElseThrow(() -> new PropsBinderException("Нету ни одного конструктора!"));
  }

  static Object resolveParameter(@NotNull Function1<String, String> getValue,
                                 @NotNull Parameter parameter) {
    return resolveParameter(getValue, parameter.getName(), parameter.getType());
  }

  static Object resolveParameter(@NotNull Function1<String, String> getValue, String name, Class<?> type) {

    if (type == String.class) return getValue.apply(name);
    if (type == int.class || type == Integer.class) return Integer.parseInt(getValue.apply(name));
    if (type == double.class || type == Double.class) return Double.parseDouble(getValue.apply(name));
    if (type == long.class || type == Long.class) return Long.parseLong(getValue.apply(name));
    if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(getValue.apply(name));
    if (type == char.class || type == Character.class) return getValue.apply(name).charAt(0);
    if (type == float.class || type == Float.class) return Float.parseFloat(getValue.apply(name));
    if (type == short.class || type == Short.class) return Short.parseShort(getValue.apply(name));
    if (type == byte.class || type == Byte.class) return Byte.parseByte(getValue.apply(name));

    return resolveObjectParameter(getValue::apply, type, name);
  }

  @NotNull
  static <T> T resolveObjectParameter(UnaryOperator<String> getProperty,
                                      @NotNull Class<T> type,
                                      String prefix) {
    if (type.isInterface() || Modifier.isAbstract(type.getModifiers()))
      throw new PropsBinderException("Type must not be an interface or abstract class!");
    return from(s -> getProperty.apply(String.format("%s.%s", prefix, s)), type);
  }
}
