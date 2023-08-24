package pro.vlapin.courses.java.fundamentals.intro.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SwitchExample {
  public static void main(String[] args) {

    firstExample();

    secondExample();

    int x = switch ("one") {
      case "one" -> 1;
      case "two" -> 2;
      case "three" -> 3;
      default -> Integer.MAX_VALUE;
    };

    log.info("x: {}", x);
  }

  private static void firstExample() {
    switch ("one") {
      case "two":
        System.out.println("two");
        break;
      case "three":
        System.out.println("three");
        break;
      case "four":
        System.out.println("four");
        break;
      case "one":
        System.out.println("one");
        break;
      default:
        System.out.println("default");
    }
  }

  private static void secondExample() {
    int x = 10;
    switch (x) {
      case 20:
        System.out.println("20");
      case 30:
        System.out.println("30");
      default:
        System.out.println("default");
      case 10:
        System.out.println("10");
      case 40:
        System.out.println("40");
    }
  }

  @SuppressWarnings("java:S1149")
  private static void m(CharSequence charSequence) {
    log.info("get: {}",
        switch (charSequence) {
          case String s -> "string: " + s;
          case StringBuffer sb -> "sb " + sb;
          case StringBuilder sb -> "sb " + sb;
          default -> throw new IllegalStateException("Unexpected value: " + charSequence);
        });
  }
}
