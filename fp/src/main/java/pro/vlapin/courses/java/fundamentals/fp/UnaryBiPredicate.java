package pro.vlapin.courses.java.fundamentals.fp;

import java.util.function.BiPredicate;

public interface UnaryBiPredicate<T> extends BiPredicate<T, T> {
  @Override
  boolean test(T o1, T o2);
}
