package pro.vlapin.courses.java.fundamentals.io.demo.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class SimpleUrlConnectionExample {

  @SneakyThrows
  public void main(String... __) {
    printContent("https://google.com");
//    printWholeHttpResponse("https://google.com");
  }

  @SneakyThrows
  private void printWholeHttpResponse(String url) {
    val connection = (HttpURLConnection) new URL(url)
        .openConnection();
    connection.setRequestMethod("GET");
  }

  @SneakyThrows
  public void printContent(String url) {
    @Cleanup val reader = new BufferedReader(
        new InputStreamReader(
            new URL(url).openStream()));

    String line;
    while ((line = reader.readLine()) != null)
      System.out.println(line);
  }
}
