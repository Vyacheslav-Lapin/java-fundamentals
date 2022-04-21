package com.epam.courses.java.fundamentals.collections;

import static lombok.AccessLevel.PRIVATE;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;
import lombok.val;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UntypedMap<K> implements Map<K, Object> {

  @Delegate
  Map<K, Object> map;

  <V> V getUntyped(K key) {
    //noinspection unchecked
    return (V) get(key);
  }

  @SuppressWarnings("unchecked")
  <V> V getUntypedProof(K key, Class<V> vClass) {
    val value = map.get(key);
    if (vClass.isInstance(value))
      return (V) value;
    else
      throw new RuntimeException("");
  }
}
