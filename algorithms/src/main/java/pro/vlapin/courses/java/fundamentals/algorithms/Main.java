package pro.vlapin.courses.java.fundamentals.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Main.
 *
 * @author Vyacheslav Lapin
 */
//todo: 09.03.2023: substitute "Main" with correct description in above javadoc
public class Main {

  public static void main(String... __) {
    String str = "Lorem ipsum dolor sit amet";
    Map<Character, Integer> result = new HashMap();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      result.compute(ch, (k,v) -> (v == null) ? 1 : ++v);
    }
    System.out.println(result);
  }
}
