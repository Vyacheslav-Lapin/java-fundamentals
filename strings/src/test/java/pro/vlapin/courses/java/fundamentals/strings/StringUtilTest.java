package pro.vlapin.courses.java.fundamentals.strings;

import lombok.SneakyThrows;
import lombok.experimental.ExtensionMethod;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@ExtensionMethod({
    StringUtil.class,
})
class StringUtilTest {

  @Test
  @SneakyThrows
  @DisplayName("GetCharCount method works correctly")
  void GetCharCount() {
    System.out.println("asdflksjdflaskdf".getCharCount());
  }
}
