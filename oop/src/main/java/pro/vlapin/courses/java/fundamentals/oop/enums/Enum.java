package pro.vlapin.courses.java.fundamentals.oop.enums;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.*;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor(access = PROTECTED)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable {

  String name;
  int ordinal;

  public final int compareTo(E o) {
    if (this.getClass() != o.getClass()
            && this.getClass().getDeclaringClass() != o.getClass().getDeclaringClass())
      throw new ClassCastException();
    return this.ordinal - o.ordinal();
  }

  @SneakyThrows
  public static <E> E valueOf(Class<E> aClass, String name) {
    //noinspection unchecked
    return (E) aClass.getMethod("valueOf", String.class)
                   .invoke(null, name);
  }
}
