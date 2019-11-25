package com.epam.courses.java.fundamentals.strings.practice.task3;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.NonFinal;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Необходимо определить в тексте статьи* (html-файл), ссылается ли автор на рисунки последовательно или нет,
 * а также выделить все предложения, в которых встречаются ссылки на рисунки.
 * Для разбора текста использовать регулярные выражения.
 */

public class Regexp {

  private String filePath;

  private String charSet;

  static String basicRegexp = "\\([Р|р]ис\\.\\s*[0-9]{1,2}";

  static String secondaryRegexp = "[Р|р]исунк[а-я]*\\s*[0-9]{1,2}";
  @NonFinal
  private ArrayList<String> phrasesWithRefs;
  @NonFinal
  private boolean refsInOrder;

  Regexp(String filePath, String charSet) {
    this.filePath = filePath;
    this.charSet = charSet;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Phrases are: \n");
    for (String str : getPhrasesWithRefs()) s.append(str).append("\n");
    System.out.println("Found phrases: " + getPhrasesWithRefs().size());
    return s.toString();
  }

  boolean areRefsInOrder() {
    if (phrasesWithRefs == null) phrasesWithRefs = parseFile();
    return refsInOrder;
  }

  ArrayList<String> getPhrasesWithRefs() {
    if (phrasesWithRefs == null) phrasesWithRefs = parseFile();
    return phrasesWithRefs;
  }

  ArrayList<String> parseFile() {
    String allText = textFromFile();
    Matcher matcherBr = Pattern.compile(basicRegexp).matcher(allText);
    Matcher matcherFl = Pattern.compile(secondaryRegexp).matcher(allText);

    ArrayList<Integer> dotPositions = new ArrayList<>();
    dotPositions.add(0);
    for (int i = 1; i < allText.length(); i++) {
      if (".".equals(String.valueOf(allText.charAt(i)))) dotPositions.add(i);
    }

    SortedSet<Integer> refStartPos = new TreeSet<>();
    HashMap<Integer, Integer> orderedPics = new HashMap<>();
    ArrayList<String> result = new ArrayList<>();

    while (matcherBr.find()) {
      String match = matcherBr.toString().trim();
      int start = matcherBr.start();
      refStartPos.add(start);
      orderedPics.put(start, Integer.parseInt(match.substring(match.lastIndexOf("(") + 6, match.lastIndexOf("]"))));
      dotPositions.removeIf((e) -> e == start + 4);
    }
    while (matcherFl.find()) {
      String match = matcherFl.toString();
      refStartPos.add(matcherFl.start());
      orderedPics.put(matcherFl.start(), Integer.parseInt(match.substring(match.lastIndexOf(" ") + 1, match.lastIndexOf("]"))));
    }

    refsInOrder = checkOrder(refStartPos, orderedPics);
    @AllArgsConstructor
    class Phrase {
      int start;

      int end;

      String phrase;

    }

    ArrayList<Phrase> phrases = new ArrayList<>();
    for (int i = 1; i < dotPositions.size(); i++) {
      for (int pic : refStartPos) {
        if (pic > dotPositions.get(i - 1) && pic < dotPositions.get(i)) {
          phrases.add(new Phrase(dotPositions.get(i - 1) + 1, dotPositions.get(i), allText.substring(dotPositions.get(i - 1) + 1, dotPositions.get(i) + 1)));
          break;
        }
      }
    }
    for (Phrase phrase : phrases) {
      String s = phrase.phrase;
      if (" ".equals(String.valueOf(s.charAt(0)))) s = s.substring(1);
      result.add(s);
    }
    return result;
  }

  private static boolean checkOrder(SortedSet<Integer> refStartPos, HashMap<Integer, Integer> orderedPics) {
    boolean result = true;
    ArrayList<Integer> sortedPos = new ArrayList<>(refStartPos);
    for (int i = 1; i < sortedPos.size(); i++) {
      if (orderedPics.get(sortedPos.get(i)) < orderedPics.get(sortedPos.get(i-1))) {
        result = false;
        break;
      }
    }
    return result;
  }

  @SneakyThrows
  private String textFromFile() {
    File taskFile = new File(filePath);
    try (BufferedReader sourceReader = new BufferedReader
        (new InputStreamReader(new FileInputStream(taskFile), charSet))) {

      StringBuilder source = new StringBuilder();
      String line;
      while ((line = sourceReader.readLine()) != null) source.append(line).append("\n");
      return source.toString().
          replace("\n", " ").
          replace("/", "").
          replace("<div>", "").
          replace("<span>", "").
          replace("<p>", "").
          replace("<br>", "").
          replace("<sub>", "").
          replace("&nbsp", "").
          replace(";", "").
          replace("  ", " ");
    }
  }
}
