package pro.vlapin.courses.java.fundamentals.intro.demo;

import org.jetbrains.annotations.Contract;

public class InstanceofExample {

  @Contract(pure = true)
  public static void main(String[] args) {
    CharSequence charSequence = "qwerty";
    example(charSequence);

//    Class.forName("h2.database.Driver");
//    DriverManager.co
  }

  private static void example(CharSequence charSequence) {
    if (charSequence instanceof String s) {
      System.out.println(s);
    }
  }
}
