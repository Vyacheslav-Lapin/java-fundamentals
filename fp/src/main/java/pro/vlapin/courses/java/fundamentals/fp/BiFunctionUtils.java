package pro.vlapin.courses.java.fundamentals.fp;

import java.util.Map.*;
import java.util.function.*;
import lombok.experimental.*;
import org.jetbrains.annotations.*;

@UtilityClass
public class BiFunctionUtils {

  public <T1, T2, R> R apply(@NotNull BiFunction<T1, T2, R> self,
                             @NotNull Entry<T1, T2> entry) {
    return self.apply(entry.getKey(), entry.getValue());
  }
}
