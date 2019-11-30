package com.epam.courses.java.fundamentals.info.task3;

import io.vavr.Tuple;
import io.vavr.Tuple3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlVerifier {
  public static ArrayList<Tuple3<String, String, Integer>> extractRefPictures(Path htmlPath) throws IOException {
    var contents = Files.readString(htmlPath, Charset.forName("windows-1251"));
    Pattern p = Pattern.compile("(([Рр]ис(?:\\.|унок) (\\d)+)[^.]*\\.)");
    Matcher m = p.matcher(contents);
    ArrayList<Tuple3<String, String, Integer>> res = new ArrayList<>();

    while (m.find()) {
      var picNum = Integer.parseInt(m.group(3));
      res.add(Tuple.of(m.group(2), m.group(1), picNum));
    }

    return res;

  }
}
