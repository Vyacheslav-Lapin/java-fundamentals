package pro.vlapin.courses.java.fundamentals.threads.demo.completablefuture;

import lombok.SneakyThrows;
import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;
import org.jsoup.Jsoup;

@UtilityClass
@ExtensionMethod({
    Jsoup.class,
})
public class HttpStackOverflowClient {

  @SneakyThrows
  public String mostRecentQuestionAbout(String tag) {
//    return Jsoup.connect(
//            String.format("http://stackoverflow.com/questions/tagged/%s", tag))
//               .get()
//               .select("a.question-hyperlink")
//               .get(0)
//               .text();
        return "http://stackoverflow.com/questions/tagged/%s"
               .formatted(tag)
               .connect()
               .get()
               .select("a.question-hyperlink")
               .get(0)
               .text();
  }
}
