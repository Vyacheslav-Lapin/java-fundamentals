package com.epam.courses.java.fundamentals.fp;

import static java.util.Spliterator.ORDERED;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Spliterators;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface StreamUtils {

  @NotNull
  static <T> Stream<T> streamOf(@NotNull Iterable<T> iterable) {
    return StreamSupport.stream(iterable.spliterator(), false);
  }

  @NotNull
  static <T> Stream<T> streamOf(Iterator<T> iterator) {
    return streamOf(iterator, false);
  }

  @NotNull
  static <T> Stream<T> streamOf(Iterator<T> iterator, boolean isParallel) {
    return StreamSupport.stream(
      Spliterators.spliteratorUnknownSize(iterator, ORDERED),
      isParallel);
  }

//  static <T> Function<T, Stream<T>> flatMapAndAddItself(Function<T, Stream<T>> mapper) {
//    return t -> {
//      mapper.apply(t).spliterator().
//    };
//  }

  @SneakyThrows
  static <T, R> R mapStream(Stream<T> stream,
                            @NotNull CheckedFunction1<Stream<T>, R> streamMapper) {
    try (stream) {
      return streamMapper.apply(stream);
    }
  }

  static <T, R> R mapStream(Iterator<T> iterator,
                            @NotNull CheckedFunction1<Stream<T>, R> streamMapper) {
    return mapStream(streamOf(iterator), streamMapper);
  }

  static <T, R> R mapStream(Iterator<T> iterator,
                            boolean isParallel,
                            @NotNull CheckedFunction1<Stream<T>, R> streamMapper) {
    return mapStream(streamOf(iterator, isParallel), streamMapper);
  }

  static <T, R> R mapStream(Iterable<T> iterable,
                            @NotNull CheckedFunction1<Stream<T>, R> streamMapper) {
    return mapStream(streamOf(iterable), streamMapper);
  }

  @SneakyThrows
  static <T> void withStream(Stream<T> stream,
                             @NotNull CheckedConsumer1<Stream<T>> checkedConsumer1) {
    try (stream) {
      checkedConsumer1.accept(stream);
    }
  }

  static <T> void withStream(Iterator<T> iterator,
                             @NotNull CheckedConsumer1<Stream<T>> checkedConsumer1) {
    withStream(streamOf(iterator), checkedConsumer1);
  }

  static <T> void withStream(Iterator<T> iterator,
                             boolean isParallel,
                             @NotNull CheckedConsumer1<Stream<T>> checkedConsumer1) {
    withStream(streamOf(iterator, isParallel), checkedConsumer1);
  }


  static <T> void withStream(Iterable<T> iterable,
                             @NotNull CheckedConsumer1<Stream<T>> checkedConsumer1) {
    withStream(streamOf(iterable), checkedConsumer1);
  }

  @NotNull
  @Contract(pure = true)
  static <E> Iterable<E> iterableOf(@NotNull Stream<E> stream) {
    return stream::iterator;
  }

  @NotNull
  @Contract(pure = true)
  static <E> Collection<E> collectionOf(@NotNull Stream<E> stream) {
    return mapStream(stream, stream1 -> stream1.collect(Collectors.toSet()));
  }

  @NotNull
  @Contract(pure = true)
  static <E> List<E> orderedCollectionOf(@NotNull Stream<E> stream) {
    return mapStream(stream, stream1 -> stream1.collect(Collectors.toList()));
  }

  @NotNull
  @Contract(" -> new")
  static <K, V> Collector<Map.Entry<K, V>, ?, Properties> toProperties() {
    //noinspection unchecked
    return new ToPropertiesCollector();
  }
}
