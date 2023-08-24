package pro.vlapin.courses.java.fundamentals.fp.demo;

import java.util.Comparator;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleStreamExample {
  public static void main(String... __) {
    Stream.of("Don't stop now and take your learning to the next level".split(" "))
        .max(Comparator.comparingInt(String::length))
        .ifPresent(log::info);
  }
}
