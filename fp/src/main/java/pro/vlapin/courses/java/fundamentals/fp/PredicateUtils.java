package pro.vlapin.courses.java.fundamentals.fp;

import java.util.Arrays;
import java.util.function.Predicate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface PredicateUtils {

  @NotNull
  @Contract(pure = true)
  static <T> Predicate<T> exact(T value) {
    return obj -> obj == value;
  }

  @NotNull
  @SafeVarargs
  @Contract(pure = true)
  static <T> Predicate<T> exactAny(T... values) {
    return obj -> Arrays.stream(values)
                    .anyMatch(value -> obj == value);
  }
}
