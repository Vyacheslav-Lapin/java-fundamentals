package pro.vlapin.courses.java.fundamentals.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UnmodifiableListUtils {

  public static void main(String... __) {
    permute(Arrays.asList("A", "B", "C"))
        .forEach(System.out::println);
  }

  public static Stream<List<String>> permute(List<String> strings) {
    int size = strings.size();
    return size == 1 ? Stream.of(strings)
               : IntStream.range(0, size)
                     .mapToObj(index -> swap(strings, 0, index))
                     .flatMap(list -> {
                       String head = list.get(0);
                       return permute(list.subList(1, size))
                                  .map(tail -> unshift(tail, head));
                     });
  }

  private static <T> List<T> swap(List<T> list, int from, int to) {
    List<T> result = new ArrayList<>(list);
    if (from != to)
      Collections.swap(result, from, to);
    return result;
  }

  private static <T> List<T> unshift(List<T> list, T element) {
    List<T> result = new ArrayList<>(list);
    result.add(0, element);
    return result;
  }
}
