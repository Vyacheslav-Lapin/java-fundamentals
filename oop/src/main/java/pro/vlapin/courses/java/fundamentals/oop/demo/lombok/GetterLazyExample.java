package pro.vlapin.courses.java.fundamentals.oop.demo.lombok;

import static lombok.AccessLevel.PRIVATE;

import java.util.Arrays;
import java.util.stream.IntStream;
import lombok.Getter;

public class GetterLazyExample {

  @Getter(value = PRIVATE, lazy = true)
  private final double[] cached =
      IntStream.range(0, 1_000_000)
          .peek(System.out::println)
          .mapToDouble(Math::asin)
          .toArray();

  public static void main(String... __) {
    System.out.println("Start...");
    System.out.printf(
        "new GetterLazyExample().getCached() = %s%n",
        Arrays.toString(new GetterLazyExample().getCached()));
  }
}
