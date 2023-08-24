package pro.vlapin.courses.java.fundamentals.algorithms;

import pro.vlapin.courses.java.fundamentals.collections.DequeUtils;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;
import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;

/**
 * Есть лестница из заданного кол-ва ступенек. Есть шаги, которые может совершать человек,
 * (он может ступать на каждую ступеньку, перешагивать через ступеньку или сразу через 2).
 * Требуется определить все возможные варианты прохождения лестницы.
 */
@UtilityClass
@ExtensionMethod({
    Arrays.class,
    DequeUtils.class,
})
public class WaysCounter {

  //todo 21.04.2022: make test
  public void main(String... __) {
    countWays(4)
        .forEach(System.out::println);
  }

  private final int[] STEPS = {1, 2, 3};

  public Stream<Deque<Integer>> countWays(int stairsLength) {
    return countWays(stairsLength, new LinkedList<>());
  }

  @SuppressWarnings("java:S1612")
  private Stream<Deque<Integer>> countWays(int stairsLength, Deque<Integer> prefix) {
    //noinspection ConstantConditions
    return stairsLength == 0 ? Stream.of(prefix)
               : STEPS.stream()
                     .filter(value -> value <= stairsLength)
                     .mapToObj(value -> prefix.immutablePush(value))
                     .flatMap(integers -> countWays(stairsLength - integers.peekLast(), integers));
  }
}
