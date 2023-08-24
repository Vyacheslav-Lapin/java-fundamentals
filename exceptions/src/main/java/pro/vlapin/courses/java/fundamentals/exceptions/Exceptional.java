package pro.vlapin.courses.java.fundamentals.exceptions;

import io.vavr.CheckedFunction1;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class Exceptional {

  @Contract("_ -> fail")
  @SuppressWarnings("unchecked")
  public <E extends Throwable, T> T sneakyThrow(Throwable e) throws E {
    throw (E) e;
  }

  public <T, R> R callUnchecked(@NotNull CheckedFunction1<T, R> checkedFunction1,
                                @NotNull T t) {
    return checkedFunction1.unchecked().apply(t);
  }
}
