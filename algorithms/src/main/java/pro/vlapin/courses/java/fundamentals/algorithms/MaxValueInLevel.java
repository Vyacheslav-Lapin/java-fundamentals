package pro.vlapin.courses.java.fundamentals.algorithms;

import pro.vlapin.courses.java.fundamentals.fp.ObjectUtils;
import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import static java.lang.Math.min;

/**
 * Вам передаётся граф в виде массива. Например: <pre>{@code
 *
 *         1            //[1,...
 *      /     \
 *     3        2       //3,...
 *  /    \    |   \
 * 5     3  null  9     //9,...
 * |\   /  \      | \
 * 4 3 null null  7  8  //8,...
 * |
 * 2                    //2]
 * }</pre><br/>
 * Требуется вернуть массив максимальных элементов для каждого ряда
 */
@UtilityClass
@ExtensionMethod({
    ArrayUtils.class,
    ObjectUtils.class
})
public class MaxValueInLevel {

  public Integer[] maxLevelValues(Integer... ints) {
    return maxValues(1, ints)
               .doWith(ArrayUtils::reverse);
  }

  /**
   * @param count кол-во элементов на текущем уровне
   * @param ints  массив оставшихся необработанными элементов
   */
  private Integer[] maxValues(int count, Integer @NotNull ... ints) {

    var max = Integer.MIN_VALUE;
    var nulls = 0;

    val length = min(count, ints.length);
    for (var i = 0; i < length; i++)
      if (ints[i] == null) nulls++;
      else if (ints[i] > max) max = ints[i];

    return ints.length <= count ? new Integer[] { max }
               : maxValues((count - nulls) * 2, ints.subarray(count, ints.length))
                     .add(max);
  }
}
