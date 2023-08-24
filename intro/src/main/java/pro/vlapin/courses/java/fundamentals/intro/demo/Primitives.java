package pro.vlapin.courses.java.fundamentals.intro.demo;

public class Primitives {

  public static void main(String... __) {

    // int intVar = 1_000_000_000L; //Error

    int intVar = 100;
    long longVar = 1_000_000_000_000L;
    intVar += longVar; // то же, что и:
    intVar = (int) (intVar + longVar);

    // intVar = intVar + longVar; // Error
  }
}
