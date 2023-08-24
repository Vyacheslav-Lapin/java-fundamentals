package pro.vlapin.courses.java.fundamentals.fp.demo.common;

import lombok.Value;
import lombok.experimental.Delegate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Value
//@RequiredArgsConstructor(staticName = "LazyNumber")//, onConstructor_ = {@Contract("_ -> new"), @NotNull}
//@AllArgsConstructor(staticName = "LazyNumber")
public class LazyNumber extends Number {

  @Delegate
  Integer value;

  @Contract("_ -> new")
  @SuppressWarnings("MethodNameSameAsClassName")
  public static @NotNull LazyNumber LazyNumber(Integer value) {
    return new LazyNumber(value);
  }

  @Contract(pure = true)
  public final @NotNull LazyNumber plus(int value) {
    return new LazyNumber(this.value + value);
  }
}
