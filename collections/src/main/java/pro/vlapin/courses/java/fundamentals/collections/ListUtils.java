package pro.vlapin.courses.java.fundamentals.collections;

import java.util.*;
import java.util.stream.*;
import lombok.experimental.*;
import lombok.*;

@UtilityClass
public class ListUtils {

  public <T> Stream<Map.Entry<Integer, T>> streamWithIndex(List<T> list) {
    return IntStream.range(0, list.size())
               .mapToObj(i -> Map.entry(i, list.get(i)));
  }

  public <T> Iterator<T> descendingIterator(List<T> list) {
    return descendingIterator(list, 0);
  }

  public <T> Iterator<T> descendingIterator(List<T> list, int index) {

    if (list instanceof LinkedList)
      return ((LinkedList<T>) list).descendingIterator();

    val listIterator = list.listIterator(index);
    return new Iterator<>() {
      @Override
      public boolean hasNext() {
        return listIterator.hasPrevious();
      }

      @Override
      public T next() {
        return listIterator.previous();
      }
    };
  }
}
