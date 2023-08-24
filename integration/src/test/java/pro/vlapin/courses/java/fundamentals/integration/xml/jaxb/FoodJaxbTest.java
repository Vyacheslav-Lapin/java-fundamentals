package pro.vlapin.courses.java.fundamentals.integration.xml.jaxb;

import io.vavr.CheckedFunction1;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.SneakyThrows;
import lombok.experimental.ExtensionMethod;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.vlapin.courses.java.fundamentals.fp.CheckedFunction1Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.*;

@ExtensionMethod({
    CheckedFunction1Utils.class,
})
class FoodJaxbTest {

  static final String XML = "stud.xml";
  static final File XML_FILE = new File(XML);

  static final Supplier<FileOutputStream> getOutputStream =
      CheckedFunction1.<String, FileOutputStream>of(FileOutputStream::new)
          .supply(XML)
          .unchecked();

  static Marshaller marshaller;
  static Unmarshaller unmarshaller;

  @BeforeAll
  @SneakyThrows
  static void setUp() {
    val jaxbContext = JAXBContext.newInstance(Food.class);
    marshaller = jaxbContext.createMarshaller();
    unmarshaller = jaxbContext.createUnmarshaller();
  }

  @Test
  @SneakyThrows
  @DisplayName("Marshall works correctly")
  void marshallWorksCorrectlyTest() {

    val food = Food.builder()
                   .id(123)
                   .name("nnn")
                   .description("ddd")
                   .calories(234)
                   .price("333")
                   .build();

    try (val fileOutputStream = getOutputStream.get()) {
      marshaller.marshal(food, fileOutputStream);
    }

    assertThat(unmarshaller.unmarshal(XML_FILE))
        .isNotNull()
        .isEqualTo(food);
  }

  @AfterEach
  void tearDown() {
    if (XML_FILE.exists())
      //noinspection ResultOfMethodCallIgnored
      XML_FILE.delete();
  }
}
