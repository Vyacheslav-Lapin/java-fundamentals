package pro.vlapin.courses.java.fundamentals.fp;

import io.vavr.CheckedFunction1;
import lombok.*;
import lombok.experimental.NonFinal;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static lombok.AccessLevel.*;

@UtilityClass
public class StreamUtils {
  private static final Object NULL_VALUE = new Object();

  @NotNull
  public <T> Stream<T> toStream(@NotNull Iterable<T> iterable) {
    return StreamSupport.stream(iterable.spliterator(), false);
  }

  @NotNull
  public <T> Stream<T> toStream(Iterator<T> iterator) {
    return toStream(iterator, false);
  }

  @NotNull
  public <T> Stream<T> toStream(Iterator<T> iterator, boolean isParallel) {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),
        isParallel);
  }

  //  public <T> Function<T, Stream<T>> flatMapAndAddItself(Function<T, Stream<T>> mapper) {
  //    return t -> {
  //      mapper.apply(t).spliterator().
  //    };
  //  }

  @SneakyThrows
  public <T, R> R mapStream(Stream<T> stream,
                            @NotNull CheckedFunction1<Stream<T>, R> streamMapper) {
    try (stream) {
      return streamMapper.apply(stream);
    }
  }

  public <T, R> R mapStream(Iterator<T> iterator,
                            @NotNull CheckedFunction1<Stream<T>, R> streamMapper) {
    return mapStream(toStream(iterator), streamMapper);
  }

  public <T, R> R mapStream(Iterator<T> iterator,
                            boolean isParallel,
                            @NotNull CheckedFunction1<Stream<T>, R> streamMapper) {
    return mapStream(toStream(iterator, isParallel), streamMapper);
  }

  public <T, R> R mapStream(Iterable<T> iterable,
                            @NotNull CheckedFunction1<Stream<T>, R> streamMapper) {
    return mapStream(toStream(iterable), streamMapper);
  }

  @SneakyThrows
  public <T> void withStream(Stream<T> stream,
                             @NotNull CheckedConsumer1<Stream<T>> checkedConsumer1) {
    try (stream) {
      checkedConsumer1.accept(stream);
    }
  }

  public <T> void withStream(Iterator<T> iterator,
                             @NotNull CheckedConsumer1<Stream<T>> checkedConsumer1) {
    withStream(toStream(iterator), checkedConsumer1);
  }

  public <T> void withStream(Iterator<T> iterator,
                             boolean isParallel,
                             @NotNull CheckedConsumer1<Stream<T>> checkedConsumer1) {
    withStream(toStream(iterator, isParallel), checkedConsumer1);
  }

  public <T> void withStream(Iterable<T> iterable,
                             @NotNull CheckedConsumer1<Stream<T>> checkedConsumer1) {
    withStream(toStream(iterable), checkedConsumer1);
  }

  @NotNull
  @Contract(pure = true)
  public <E> Iterable<E> toIterable(@NotNull Stream<E> stream) {
    return stream::iterator;
  }

  @NotNull
  @Contract(pure = true)
  public <E> Collection<E> toCollection(@NotNull Stream<E> stream) {
    return mapStream(stream, stream1 -> stream1.collect(Collectors.toSet()));
  }

  @NotNull
  @Contract(pure = true)
  public <E> List<E> toOrderedCollection(@NotNull Stream<E> stream) {
    return mapStream(stream, stream1 -> stream1.collect(Collectors.toList()));
  }

  @NotNull
  public <K, V> Properties toProperties(Stream<Map.Entry<K, V>> stream) {
    return stream.collect(new ToPropertiesCollector<>());
  }

  /**
   * taken from https://stackoverflow.com/questions/41651409/how-to-implement-a-parallel-supporting-takewhile-for-the-stream-api-in-java-8
   */
  @NotNull
  public <T> Stream<T> takeWhile(Stream<T> stream, Predicate<? super T> predicate) {
    return StreamSupport.stream(new UnorderedTakeWhileSpliterator<>(stream.spliterator(), predicate), stream.isParallel());
  }

  @SuppressWarnings("unchecked")
  public <T> Stream<T> reverse(@NotNull Stream<? extends T> input) {
    val temp = input.toArray();
    return (Stream<T>) IntStream.range(0, temp.length)
        .mapToObj(i -> temp[temp.length - i - 1]);
  }

  @NotNull
  public <T> Stream<T> skip(final Stream<T> s, int count) {
    if (count == 0) return s;
    if (count > 0) return s.skip(count);
    val pending = new ArrayDeque<T>(1 - count);
    val srcSpliterator = s.spliterator();
    return StreamSupport.stream(new Spliterator<>() {
      public boolean tryAdvance(Consumer<? super T> action) {
        while (pending.size() <= -count
            && srcSpliterator.tryAdvance(pending::add)) ;
        if (pending.size() > -count) {
          action.accept(pending.remove());
          return true;
        }
        return false;
      }

      public Spliterator<T> trySplit() {
        return null;
      }

      public long estimateSize() {
        return srcSpliterator.estimateSize() - count;
      }

      public int characteristics() {
        return srcSpliterator.characteristics();
      }
    }, false);
  }

  @AllArgsConstructor
  @RequiredArgsConstructor
  private static final class UnorderedTakeWhileSpliterator<T> implements Spliterator<T>, Consumer<T>, Cloneable {

    AtomicBoolean checked = new AtomicBoolean();

    @NonFinal
    T cur;

    @With(PRIVATE)
    Spliterator<T> source;

    Predicate<? super T> predicate;

    @Override
    @Contract(mutates = "this")
    public void accept(T t) {
      cur = t;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
      if (!checked.get() && source.tryAdvance(this))
        if (predicate.test(cur)) {
          action.accept(cur);
          return true;
        } else
          checked.set(true);
      return false;
    }

    @Override
    @SneakyThrows
    public Spliterator<T> trySplit() {
      val prefix = source.trySplit();
      return prefix == null ? null
                 : checked.get() ?
                       Spliterators.emptySpliterator()
                       : withSource(prefix);
    }

    @Override
    public long estimateSize() {
      return source.estimateSize();
    }

    @Override
    public int characteristics() {
      return source.characteristics() & (DISTINCT | SORTED | NONNULL);
    }

    @Override
    public Comparator<? super T> getComparator() {
      return source.getComparator();
    }
  }
}
