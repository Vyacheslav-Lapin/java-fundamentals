package com.epam.courses.java.fundamentals.oop.demo;

import java.util.List;
import lombok.Builder.Default;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;

//@Getter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Value//(staticConstructor = "of")
//@Data
@SuperBuilder(toBuilder = true)
@NonFinal
public class Person {

  String name;

  @Default
  int age = 16;
  double height;

  @Singular
  List<String> contacts;
}
