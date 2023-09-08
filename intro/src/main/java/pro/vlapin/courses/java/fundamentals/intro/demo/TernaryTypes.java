package pro.vlapin.courses.java.fundamentals.intro.demo;

import static java.lang.System.*;

/**
 * Wrappers.
 */
@SuppressWarnings({
    "java:S2129",
    "java:S5738",
    "java:S2154",
    "java:S2583",
    "removal",
    "CachedNumberConstructorCall",
    "ConstantConditionalExpression",
    "ConstantValue",
    "UnnecessaryBoxing"})
public class TernaryTypes {
  public static void main(String... __) {
    Object o1 = true ? new Integer(1) : new Double(2.0);

    Object o2;
    if (true) {
      o2 = new Integer(1);
    } else {
      o2 = new Double(2.0);
    }

    out.println("o1 = " + o1);
    out.println("o1 instanceof Double = " + (o1 instanceof Double));
    out.println("o1.getClass() = " + o1.getClass());

    out.println("o2 = " + o2);
    out.println("o2 instanceof Integer = " + (o2 instanceof Integer));
    out.println("o2.getClass() = " + o2.getClass());
  }
}
