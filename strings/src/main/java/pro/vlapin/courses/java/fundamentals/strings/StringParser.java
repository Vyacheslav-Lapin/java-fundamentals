package pro.vlapin.courses.java.fundamentals.strings;

import static java.util.regex.Pattern.*;

import java.util.regex.*;
import lombok.experimental.*;
import lombok.*;

@UtilityClass
public class StringParser {

  public Double doubleStartsWith(String s) {
    if (s != null) {
      val matcher = compile("^([+\\-\\d.]*)").matcher(s);
      if (matcher.find() && matcher.start(0) < matcher.end(0))
        return Double.parseDouble(matcher.group(0));
    }
    return null;
  }

  public String withoutStartedNumber(String s) {
    if (s != null) {
      val matcher = compile("^([\\d.]*)").matcher(s);
      if (matcher.find() && matcher.start(0) < matcher.end(0))
        return s.substring(matcher.end(0));
    }
    return s;
  }

  public Double intStartsWith(String s) {
    if (s != null) {
      val matcher = Pattern.compile("^([\\d.]*)").matcher(s);
      if (matcher.find() && matcher.start(0) < matcher.end(0))
        return Double.parseDouble(matcher.group(0));
    }
    return .0;
  }
}
