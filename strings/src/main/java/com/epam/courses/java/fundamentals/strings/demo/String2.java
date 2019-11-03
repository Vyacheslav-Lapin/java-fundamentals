package com.epam.courses.java.fundamentals.strings.demo;

public class String2 {

  public static void main(String... __) {
    String str1 = "Hello";
    String str2 = new String("Hello");
    if (str1 == str2) System.out.println("Equal");
    else System.out.println("Not Equal");

    str2 = str2.intern();
    if (str1 == str2) System.out.println("Equal");
    else System.out.println("Not Equal");

    if (str1.equals(str2)) System.out.println("Equal");
    else System.out.println("Not Equal");
  }
}
