package com.epam.courses.java.fundamentals.jdbc.cp;

import io.vavr.Function1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

  @SneakyThrows
  @NotNull
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

  @SuppressWarnings("unchecked")
  static Object resolveParameter(@NotNull Function1<String, String> getValue,
                                 @NotNull Parameter parameter) {

    String name = parameter.getName();
    String value = getValue.apply(name);
    Class<?> type = parameter.getType();

    if (type == String.class) return value;
    if (type == int.class || type == Integer.class) return Integer.parseInt(value);
    if (type == double.class || type == Double.class) return Double.parseDouble(value);
    if (type == long.class || type == Long.class) return Long.parseLong(value);
    if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(value);
    if (type == char.class || type == Character.class) return value.charAt(0);
    if (type == float.class || type == Float.class) return Float.parseFloat(value);
    if (type == short.class || type == Short.class) return Short.parseShort(value);
    if (type == byte.class || type == Byte.class) return Byte.parseByte(value);

    String prefix = name + ".";
    return from(propertyName -> getValue.apply(prefix + propertyName), type);
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
