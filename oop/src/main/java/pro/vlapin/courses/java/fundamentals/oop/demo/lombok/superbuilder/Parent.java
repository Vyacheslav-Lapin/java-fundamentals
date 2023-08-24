package pro.vlapin.courses.java.fundamentals.oop.demo.lombok.superbuilder;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Parent {
  String parentName;
  int parentAge;
}
