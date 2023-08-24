package pro.vlapin.courses.java.fundamentals.threads.demo.completablefuture;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class HttpStackOverflowClientTest {

  @Test
  @SneakyThrows
  @DisplayName(" works correctly")
  void worksCorrectlyTest() {
    val javaQuestion = HttpStackOverflowClient.mostRecentQuestionAbout("java");
    log.info("javaQuestion: {}", javaQuestion);
    assertThat(javaQuestion).isNotNull()
        .isNotEmpty();
  }
}
