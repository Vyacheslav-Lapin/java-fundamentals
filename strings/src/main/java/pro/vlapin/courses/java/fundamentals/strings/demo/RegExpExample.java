package pro.vlapin.courses.java.fundamentals.strings.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.FieldDefaults;
import lombok.val;

import static lombok.AccessLevel.*;

@FieldDefaults(level = PRIVATE)
public final class RegExpExample {

  public static void main(String... __) {
    val text = "Java is fun; JavaScript is funny.; JFunny ; just";
    final Pattern pattern = Pattern.compile("J(\\w*)", Pattern.CASE_INSENSITIVE);
    final Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      final int start = matcher.start(0);
      final int end = matcher.end(0);

      System.out.printf("Found '%s' at position %d-%d\n",
          matcher.group(0),
          start,
          end);

      if (start < end)
        System.out.println("Suffix is " + matcher.group(1));
    }
  }
}
