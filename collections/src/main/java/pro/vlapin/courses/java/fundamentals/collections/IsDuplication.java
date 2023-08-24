package pro.vlapin.courses.java.fundamentals.collections;

import java.util.TreeSet;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class IsDuplication {

  public boolean isUnique(Integer @NotNull ... nums) {
    val o = new TreeSet<Integer>();
    for (val num : nums)
      if (!o.add(num))
        return false;
    return true;
  }
}
