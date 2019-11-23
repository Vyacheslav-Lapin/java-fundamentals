package com.epam.courses.java.fundamentals.strings.demo;

import static lombok.AccessLevel.PRIVATE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
public final class RegExpExample {

  public static void main(String... __) {
    var text = "Java is fun; JavaScript is funny.; JFunny ; just";
    Pattern p = Pattern.compile("J(\\w*)", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(text);
    while (m.find()) {
      int start = m.start(0);
      int end = m.end(0);
      System.out.printf("Found '%s' at position %d-%d\n", m.group(0), start, end);
      if (start < end)
        System.out.println("Suffix is " + m.group(1));
    }
  }
}
