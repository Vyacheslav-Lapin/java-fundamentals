package pro.vlapin.courses.java.fundamentals.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Stream;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class StreamFormatter {

  public <T, V> Stream<? extends T> cleanup(@NotNull Stream<? extends T> stream,
                                  @NotNull UnaryBiPredicate<? super T> shouldErase,
                                  @NotNull BiFunction<? super T, ? super V, ? extends T> fieldWither) {
    val list = stream.toList();
    List<T> result = new ArrayList<>(list.size());
    result.add(list.get(0));
    for (var i = 1; i < list.size(); i++) {
      val previous = list.get(i - 1);
      val that = list.get(i);
      result.add(
          shouldErase.test(previous, that) ?
              fieldWither.apply(that, null)
              : that);
    }
    return result.stream();
  }

//  public <T, V> Stream<T> cleanup(@NotNull Stream<? extends T> stream,
//                                  @NotNull Function<? extends T, ?> valueExtractor4Comparison,
//                                  @NotNull BiFunction<T, V, T> fieldWither) {
//    return cleanup(stream,
//        (T t, Object t2) -> valueExtractor4Comparison.apply(t)
//                       .equals(valueExtractor4Comparison.apply(t2)),
//        fieldWither);
//  }

  public <T, V> Stream<T> enrich(@NotNull Stream<T> stream,
                                 @NotNull BiPredicate<T, T> shouldEnrich,
                                 @NotNull Function<T, V> fieldExtractor,
                                 @NotNull BiFunction<T, V, T> fieldWither) {
    val list = stream.toList();
    val result = new ArrayList<T>(list.size());
    val first = list.get(0);
    result.add(first);
    var value = fieldExtractor.apply(first);
    for (var i = 1; i < list.size(); i++) {
      val previous = list.get(i - 1);
      val that = list.get(i);
      if (shouldEnrich.test(previous, that))
        result.add(fieldWither.apply(that, value));
      else {
        value = fieldExtractor.apply(that);
        result.add(that);
      }
    }
    return result.stream();
  }

  public <T, V> Stream<T> enrich(@NotNull Stream<T> stream,
                                 @NotNull Function<T, ?> valueExtractor4Comparison,
                                 @NotNull Function<T, V> fieldExtractor,
                                 @NotNull BiFunction<T, V, T> fieldWither) {
    return enrich(stream,
        (t, t2) -> valueExtractor4Comparison.apply(t)
                       .equals(valueExtractor4Comparison.apply(t2)),
        fieldExtractor,
        fieldWither);
  }
}
