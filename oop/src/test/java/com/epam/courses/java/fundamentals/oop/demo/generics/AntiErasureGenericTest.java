package com.epam.courses.java.fundamentals.oop.demo.generics;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AntiErasureGenericTest {

  static class FloatList extends ArrayList<Float> {
  }

  @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
  ArrayList<Float> listOfNumbers = new FloatList();

  @Test
  @DisplayName("Generics can works without erasure")
  void genericsWorksWithoutErasureTest() {
    assertThat(listOfNumbers.getClass().getGenericSuperclass())
        .hasToString("java.util.ArrayList<java.lang.Float>")
        .isInstanceOf(ParameterizedType.class)
        .extracting(ParameterizedType.class::cast)
        .extracting(type -> (Class<?>) type.getActualTypeArguments()[0])
        .hasToString("class java.lang.Float");
  }
}
