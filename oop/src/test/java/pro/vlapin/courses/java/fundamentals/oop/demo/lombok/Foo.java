package pro.vlapin.courses.java.fundamentals.oop.demo.lombok;

import java.util.Objects;
import lombok.experimental.NonFinal;

public class Foo {
  @NonFinal private int x;
  @NonFinal private String s;

  // Как писать/генерировать
  // методы equals и hashCode?
  public boolean equals(final Object o) {
    return o == this
               || o instanceof Foo other
                      && other.canEqual(this)
                      && this.x == other.x
                      && Objects.equals(this.s, other.s);
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Foo;
  }

  public int hashCode() {
    final int PRIME = 59;
    return (PRIME + this.x) * PRIME
               + (this.s == null ? 43
                      : ((Object) this.s).hashCode());
  }
}
