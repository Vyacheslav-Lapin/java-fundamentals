package com.epam.courses.java.fundamentals.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class Make {

  @Contract(pure = true)
  public @NotNull Map<Character, Integer> getCharCount(@NotNull String chars) {
    return chars.chars().collect(
        HashMap::new,
        (hashMap, value) -> hashMap.merge((char) value, 1, Integer::sum),
        HashMap::putAll);
  }

  public Map<Character, Integer> countDuplicateCharacters(String s) {
    val result = new HashMap<Character, Integer>();
    for (char c : s.toCharArray())
      result.compute(c, (character, integer) -> integer == null ? 1 : integer + 1);
    return result;
  }

  public Map<Character, Long> countDuplicateCharactersJava8(String s) {
    return s.chars()
        .mapToObj(value -> (char) value)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
