package pro.vlapin.courses.java.fundamentals.oop.demo.strings;

public class StringsDemo {

  public static void main(String... __) {
    var str = "I like ";
    System.out.println("Before: " + str);
    changeString(str);
    System.out.println("After: " + str);

    // --------------------------------

    byte a = 5;
    short b = 8;
    char c = 'a';
    int d = a + b + c; // (int) a + (int) b + (int) c
    long e = 1L + d; // => 1L + (long) d
    float f = 5.2f + e; // => 5.2f + (float) e
    double g = 1.1 + f; // 1.1 + (double) f
    String h = "" + g; // new StringBuilder("").append(g).toString()
    System.out.println(h);
  }

  public static void changeString(String s) {
    System.out.println("	- before \"change\": " + s);
    s = s + " Java.";
    System.out.println("	- after \"change\": " + s);
  }
}
