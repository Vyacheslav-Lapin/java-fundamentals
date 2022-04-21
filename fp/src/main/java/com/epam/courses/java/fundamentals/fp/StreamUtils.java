package com.epam.courses.java.fundamentals.fp;

import static lombok.AccessLevel.PRIVATE;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.With;
import lombok.experimental.NonFinal;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class StreamUtils {
  //public interface StreamUtils {

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
