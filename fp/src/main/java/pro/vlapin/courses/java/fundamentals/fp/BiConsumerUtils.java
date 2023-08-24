package pro.vlapin.courses.java.fundamentals.fp;

import io.vavr.Tuple2;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class BiConsumerUtils {

  public <T, U> void accept(@NotNull BiConsumer<T, U> self,
                            @NotNull Map.Entry<T, U> entry) {
    self.accept(entry.getKey(), entry.getValue());
  }

  public <T, U> Consumer<U> accept(@NotNull BiConsumer<T, U> self,
                                   @NotNull T t) {
    return u -> self.accept(t, u);
  }

  public <T, U> Consumer<T> accept2(@NotNull BiConsumer<T, U> self,
                                    @NotNull U u) {
    return t -> self.accept(t, u);
  }

  /**
   * Alias for {@link #accept2(BiConsumer, Object)}
   */
  public <T, U> Consumer<T> acceptRight(@NotNull BiConsumer<T, U> self,
                                        @NotNull U u) {
    return accept2(self, u);
  }

  public <T, U> Consumer<Tuple2<T, U>> tupled(@NotNull BiConsumer<T, U> self) {
    return tuple2 -> self.accept(tuple2._1, tuple2._2);
  }
}
