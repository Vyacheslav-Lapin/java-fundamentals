package pro.vlapin.courses.java.fundamentals.intro.demo;

import org.jetbrains.annotations.Contract;

public class BreacAndContinueExample {

  @Contract(pure = true)
  public static void main(String[] args) {
    simpleExample(args);
  }

  @Contract(pure = true)
  private static void simpleExample(String[] args) {
    Outer:
    for(int i = 0; i < args.length ; i++) {
      // ...
      break Outer;
      // ...
    }
  }
}
