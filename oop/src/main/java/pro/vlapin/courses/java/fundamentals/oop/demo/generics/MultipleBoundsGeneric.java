package pro.vlapin.courses.java.fundamentals.oop.demo.generics;

import java.util.Arrays;
import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
@ExtensionMethod({
    Arrays.class,
})
public class MultipleBoundsGeneric {
  public <T extends Number & Comparable<T>> T maximum(T... xs) {
    T x = xs[0];
    if (xs.length == 1) return x;
    val tailMax = maximum(xs.copyOfRange(1, xs.length));
    return x.compareTo(tailMax) > 0 ? x : tailMax;
  }
}
