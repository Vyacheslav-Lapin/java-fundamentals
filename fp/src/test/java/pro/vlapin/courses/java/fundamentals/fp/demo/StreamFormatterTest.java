package pro.vlapin.courses.java.fundamentals.fp.demo;

import java.util.stream.*;
import lombok.*;
import org.junit.jupiter.api.*;
import pro.vlapin.courses.java.fundamentals.fp.StreamFormatter;

class StreamFormatterTest {

  @Test
  @SneakyThrows
  @DisplayName("Stream enricher works correctly")
  void streamEnricherWorksCorrectlyTest() {
    System.out.println(StreamFormatter.enrich(
        Stream.of(new TestClass("l", 1)
            , new TestClass("l", null)
            , new TestClass("l", null)
            , new TestClass("r", 2)
            , new TestClass("r", null)
        ),
        TestClass::getS,
        TestClass::getI,
        TestClass::withI
    ).collect(Collectors.toList()));
  }

//  @Test
//  @SneakyThrows
//  @DisplayName("Stream cleanup works correctly")
//  void streamCleanupWorksCorrectlyTest() {
//    System.out.println(StreamFormatter.cleanup(
//        Stream.of(new TestClass("l", 1)
//            , new TestClass("l", 1)
//            , new TestClass("l", 1)
//            , new TestClass("r", 2)
//            , new TestClass("r", 2)
//        ),
//        TestClass::getS,
//        TestClass::withI
//    ).collect(Collectors.toList()));
//  }
}

@With
@Value
class TestClass {
  String s;
  Integer i;
}
