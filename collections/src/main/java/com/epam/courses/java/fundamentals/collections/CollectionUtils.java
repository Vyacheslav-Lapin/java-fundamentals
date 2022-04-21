package com.epam.courses.java.fundamentals.collections;

import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

import java.util.Iterator;
import java.util.stream.Stream;

public interface CollectionUtils {

  static <T> Stream<T> toStream(Iterator<T> iterator) {
    return stream(spliteratorUnknownSize(iterator, ORDERED), false);
  }
}
