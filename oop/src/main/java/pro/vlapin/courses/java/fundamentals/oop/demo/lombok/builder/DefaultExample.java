package pro.vlapin.courses.java.fundamentals.oop.demo.lombok.builder;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;

@Getter
@Builder
public class DefaultExample {
  @Default int x = 100_500;
  @Default String s = "lorem";
  @Default boolean b = true;
}
