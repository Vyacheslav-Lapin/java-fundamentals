package com.epam.courses.java.fundamentals.oop.demo;

import java.util.function.Supplier;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

public interface MyCoolInterface {

  /*public static final */ int x = 54;

  /* public */ void met();

  @SneakyThrows
  private @NotNull String m1(@NotNull int x) {
    return "kjhsdkjhdssdg" + x + "kjhsdggkjdsg";
  }

  static void main(String... __) {
    System.out.println("kjhsdf");
  }

}
