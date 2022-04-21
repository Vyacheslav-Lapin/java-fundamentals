package com.epam.courses.java.fundamentals.algorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WaysCounter {

  //todo 21.04.2022: make test
  public void main(String... __) {
    countWays(6)
        .forEach(System.out::println);
  }

  private int[] STEPS = {1, 2, 3};

  public Stream<Deque<Integer>> countWays(int stairsLength) {
    return countWays(stairsLength, new LinkedList<>());
  }
  private Stream<Deque<Integer>> countWays(int stairsLength, Deque<Integer> prefix) {
    //noinspection ConstantConditions
    return stairsLength == 0 ? Stream.of(prefix)
               : Arrays.stream(STEPS)
                     .filter(value -> value <= stairsLength)
                     .mapToObj(value -> immutablePush(prefix, value))
                     .flatMap(integers -> countWays(stairsLength - integers.peekLast(), integers));
  }

  private Deque<Integer> immutablePush(Deque<Integer> prefix, int value) {
    Deque<Integer> integers = new LinkedList<>(prefix);
    integers.offer(value);
    return integers;
  }
}
