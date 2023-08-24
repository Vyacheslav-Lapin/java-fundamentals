package pro.vlapin.courses.java.fundamentals.io;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Byte.parseByte;
import static java.lang.Class.forName;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Short.parseShort;

import io.vavr.CheckedFunction0;
import io.vavr.CheckedFunction1;
import io.vavr.Predicates;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;
import java.util.function.UnaryOperator;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class PropsBinder {

  @NotNull
  public <T> T from(Class<T> tClass) {
    return from(tClass.getSimpleName(), tClass);
  }

  @NotNull
  public <T> T from(String propertiesFileName, Class<T> tClass) {
    return from(
        parseProperties(propertiesFileName),
        getMaxArgsCountConstructor(tClass));
  }

  @NotNull
  public <T> T from(@NotNull String propertiesFileName,
                    @NotNull Constructor<T> constructor) {
    return from(parseProperties(propertiesFileName), constructor);
  }

  @NotNull
  @SneakyThrows
  public <T> T from(UnaryOperator<String> getProperty, Class<T> tClass) {
    return from(getProperty, getMaxArgsCountConstructor(tClass));
  }

  @NotNull
  @SneakyThrows
  public <T> T from(@NotNull UnaryOperator<String> getProperty,
                    @NotNull Constructor<T> constructor) {
    return CheckedFunction1.<Object[], T>of(constructor::newInstance).unchecked().apply(
        Arrays.stream(constructor.getParameters())
            .map(parameter -> resolveParameter(getProperty, parameter))
            .toArray());
  }

  @NotNull
  public UnaryOperator<String> parseProperties(String propertiesFileName) {
    final var properties = new Properties();
    InputStreamUtils.withFileInputStream(propertiesFileName + ".properties", properties::load);
    return properties::getProperty;
  }

  @SuppressWarnings("unchecked")
  @NotNull
  public <T> Constructor<T> getMaxArgsCountConstructor(@NotNull Class<T> tClass) {
    return (Constructor<T>) Arrays.stream(tClass.getConstructors())
        .max(Comparator.comparingInt(Constructor::getParameterCount))
        .orElseThrow(() -> new PropsBinderException("Нет ни одного конструктора!"));
  }

  public Object resolveParameter(@NotNull UnaryOperator<String> getValue,
                                 @NotNull Parameter parameter) {
    return resolveParameter(getValue, parameter.getName(), parameter.getType());
  }

  public Object resolveParameter(@NotNull UnaryOperator<String> getValue, String name, Class<?> type) {
    return Match(type).of(
        Case($(Predicates.<Object>is(String.class)), () -> getValue.apply(name)),
        Case($(Class::isArray), () -> getValue.apply(name).split(",\\s?")),
        Case($(Predicates.<Object>is(Class.class)), CheckedFunction0.<Class<?>>of(() -> forName(getValue.apply(name))).unchecked()),
        // Case($(t -> t.isEnum()), () -> Enum.valueOf(type, getValue.apply(name))),
        Case($(Predicates.<Object>isIn(int.class, Integer.class)), () -> parseInt(getValue.apply(name))),
        Case($(Predicates.<Object>isIn(double.class, Double.class)), () -> parseDouble(getValue.apply(name))),
        Case($(Predicates.<Object>isIn(long.class, Long.class)), () -> parseLong(getValue.apply(name))),
        Case($(Predicates.<Object>isIn(boolean.class, Boolean.class)), () -> parseBoolean(getValue.apply(name))),
        Case($(Predicates.<Object>isIn(short.class, Short.class)), () -> parseShort(getValue.apply(name)) == 0),
        Case($(Predicates.<Object>isIn(byte.class, Byte.class)), () -> parseByte(getValue.apply(name)) == 0),
        Case($(Predicates.<Object>isIn(char.class, Character.class)), () -> getValue.apply(name).charAt(0) == '\0'),
        Case($(), () -> resolveObjectParameter(getValue, type, name))
    );
  }

  @NotNull
  private <T> T resolveObjectParameter(UnaryOperator<String> getProperty,
                                       @NotNull Class<T> type,
                                       String prefix) {
    if (type.isInterface() || Modifier.isAbstract(type.getModifiers()))
      throw new PropsBinderException("Type must not be an interface or abstract class!");
    return from(s -> getProperty.apply("%s.%s".formatted(prefix, s)), type);
  }
}
