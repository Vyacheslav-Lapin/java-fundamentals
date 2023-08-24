package pro.vlapin.courses.java.fundamentals.fp.demo;

import java.util.stream.IntStream;

import static java.lang.System.*;

public class FizzBuzz {
  public static void main(String... __) {
    IntStream.rangeClosed(1, 100)
        .forEach(value -> {
          var s = "";
          if (value % 3 == 0)
            out.print(s = "Fizz");
          if (value % 5 == 0)
            out.print(s = "Buzz");
          out.println(s.isEmpty() ? Integer.toString(value) : "");
        });
  }
}
