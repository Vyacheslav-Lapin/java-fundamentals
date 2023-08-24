package pro.vlapin.courses.java.fundamentals.oop.demo.lombok;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public final class Extensions {
  //public interface Extensions {

  @Contract(value = "null, _ -> param2; !null, _ -> param1", pure = true)
  public static <T> T or(T that, T ifNull) {
    return that == null ? ifNull : that;
  }

  public static String toTitleCase(@NotNull String that) {
    return that.isEmpty() ? that :
               String.format("%s%s",
                   Character.toTitleCase(that.charAt(0)),
                   that.substring(1).toLowerCase());
  }
}
