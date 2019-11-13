package com.epam.courses.java.fundamentals.threads;

import java.util.EnumSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToPropertiesCollector<K, V> implements
  Collector<Map.Entry<K, V>, Properties, Properties> {

  @Override
  public Supplier<Properties> supplier() {
    return Properties::new;
  }

  @Override
  public BiConsumer<Properties, Map.Entry<K, V>> accumulator() {
    return (properties, entry) ->
             properties.put(
               entry.getKey().toString(),
               entry.getValue().toString());
  }

  @Override
  public BinaryOperator<Properties> combiner() {
    return (left, right) -> {
      left.putAll(right);
      return left;
    };
  }

  @Override
  public Function<Properties, Properties> finisher() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Set<Characteristics> characteristics() {
    return EnumSet.of(
      Characteristics.IDENTITY_FINISH,
      Characteristics.UNORDERED);
  }
}
