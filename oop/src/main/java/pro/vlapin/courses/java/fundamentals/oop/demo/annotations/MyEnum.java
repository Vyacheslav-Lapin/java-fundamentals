package pro.vlapin.courses.java.fundamentals.oop.demo.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public enum MyEnum {
  A(0.0, 0, "");

  MyEnum(@Foo("double annotated") double d,
         int i,
         @Foo("string annotated") String s) { }

  @Retention(RetentionPolicy.RUNTIME)
  @interface Foo {String value();}

  public static void main(String[] args) {
    Arrays.stream(MyEnum.class.getDeclaredConstructors()[0].getParameters())
        .filter(p -> p.getType() == double.class)
        .forEach(p -> System.out.println(p.getAnnotation(Foo.class).value()));
  }
}
