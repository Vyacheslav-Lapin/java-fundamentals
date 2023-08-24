package pro.vlapin.courses.java.fundamentals.collections;

import java.util.Deque;
import java.util.LinkedList;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DequeUtils {

  public <T> Deque<T> immutablePush(Deque<T> prefix, T value) {
    Deque<T> integers = new LinkedList<>(prefix);
    integers.offer(value);
    return integers;
  }
}
