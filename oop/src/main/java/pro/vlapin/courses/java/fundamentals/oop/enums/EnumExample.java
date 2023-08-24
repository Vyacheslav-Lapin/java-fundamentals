package pro.vlapin.courses.java.fundamentals.oop.enums;

import java.util.Arrays;
import lombok.Getter;
import lombok.experimental.Accessors;

//public enum EnumExample { FIRST, SECOND }
@Accessors(fluent = true)
public final class EnumExample extends Enum<EnumExample> {

  @Getter
  private static final EnumExample[] values = new EnumExample[2];

  private EnumExample(String name, int ordinal) {
    super(name, ordinal);
    values[ordinal] = this;
  }

  public static final EnumExample FIRST = new EnumExample("FIRST", 0);
  public static final EnumExample SECOND = new EnumExample("SECOND", 1);

  public static EnumExample valueOf(String name) {
    return Arrays.stream(values())
               .filter(enumExample -> enumExample.name().equals(name))
               .findFirst()
               .orElseThrow(IllegalArgumentException::new);
  }
}
