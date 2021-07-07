package com.epam.courses.java.fundamentals.IO.practice.task1_2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public interface StringParser {
  File source = new File("io/src/main/java/com/epam/courses/java/fundamentals/IO/practice/task1_2/PenClassAsExample.java");
  File templ = new File("io/src/main/java/com/epam/courses/java/fundamentals/IO/practice/task1_2/keywords.txt");
  File output = new File("io/src/main/java/com/epam/courses/java/fundamentals/IO/practice/task1_2/output.txt");

  default String parse(String source, String template) {
    Set<String> keys = Arrays.stream(template.split("\n")).
        collect(Collectors.toCollection(HashSet::new));
    ArrayList<String> words = Arrays.
        stream(source.split("[ ,.\n;:+*=&?{}()!\"//|·]")).
        distinct().sorted(String::compareTo).
        collect(Collectors.toCollection(ArrayList::new));
    String result = "";
    for(String word : words){
      for(String key : keys){
        if (word.equals(key)){
          result+=key;
          result+="\n";
        }
      }
    }
    result +="\nTotally "+result.split("\n").length+" Java key words in class Pen";
    return result;
  }
}
