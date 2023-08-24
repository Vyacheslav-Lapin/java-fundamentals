package pro.vlapin.courses.java.fundamentals.fp;

import io.vavr.CheckedFunction1;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class CheckedFunction1Utils {

  @SneakyThrows
  public <T extends AutoCloseable, R> R mapAndCleanup(@NotNull CheckedFunction1<T, R> self,
                                                      @NotNull T obj,
                                                      @NotNull CheckedFunction1<T, R> function1) {
    try (obj) {
      return function1.apply(obj);
    }
  }

  public <T, R> CheckedFunction0<R> supply(@NotNull CheckedFunction1<T, R> self,
                                           @NotNull T t) {
    return () -> self.apply(t);
  }
}
