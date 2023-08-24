package pro.vlapin.courses.java.fundamentals.oop.demo.lombok;

import java.util.Arrays;
import lombok.experimental.ExtensionMethod;

@ExtensionMethod({Arrays.class, Extensions.class})
class LombokExtensionMethodExample {
  String useExtensionMethods(LombokExtensionMethodExample this) {
    String iAmNull = null;

    //return Extensions.or(iAmNull, Extensions.toTitleCase("hELlO, WORlD!"));
    return iAmNull.or("hELlO, WORlD!".toTitleCase());
  }

  @SuppressWarnings("WeakerAccess")
  public final int[] getSortedArray() {
    int[] intarray = {5, 3, 8, 2};

    //arrays.sort(intarray);
    intarray.sort();

    return intarray;
  }
}
