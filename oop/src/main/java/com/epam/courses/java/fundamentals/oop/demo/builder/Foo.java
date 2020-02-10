package com.epam.courses.java.fundamentals.oop.demo.builder;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.experimental.NonFinal;
import lombok.val;

public class Foo {
  @NonFinal
  int x;
  String s;
  boolean b;
  List<String> strings;

  @Builder
  private Foo(String s, boolean b, @Singular List<String> strings) {
    this.s = s;
    this.b = b;
    this.strings = strings;
  }

  public static void main(String... __) {
    val foo = Foo.builder()
                  .s("lorem")
                  .b(true)
                  .string("hjbdfg")
                  .string("kjhgdfe")
                  .build();
  }
}
