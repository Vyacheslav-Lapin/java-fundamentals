package com.epam.courses.java.fundamentals.collections;

import static lombok.AccessLevel.PRIVATE;

import com.epam.courses.java.fundamentals.fp.FunctionUtils;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

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
    return (V) FunctionUtils.anAssert(get(key), it -> it.getClass() == vClass);
  }
}
