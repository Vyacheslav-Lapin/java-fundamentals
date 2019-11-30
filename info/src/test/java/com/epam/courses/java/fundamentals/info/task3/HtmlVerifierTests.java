package com.epam.courses.java.fundamentals.info.task3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class HtmlVerifierTests {
  @Test
  void checkImages() throws URISyntaxException, IOException {
    URL url = getClass().getResource("/Java.SE.03.Information handling_task_attachment.html");
    Path htmlPath = Paths.get(url.toURI());
    var picAndStatements = HtmlVerifier.extractRefPictures(htmlPath);
    assertFalse(picAndStatements.isEmpty());

    Integer prev = null;
    boolean isAsc = true;
    for (var picAndStatement : picAndStatements) {
      var cur = picAndStatement._3;
      if (prev != null && cur < prev) {
        isAsc = false;
        break;
      }

      prev = cur;
    }

    assertFalse(isAsc);
  }
}
