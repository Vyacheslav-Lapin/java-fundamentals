package com.epam.courses.java.fundamentals.integration;

import static com.epam.courses.java.fundamentals.io.InputStreamUtils.getFileAsString;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.courses.java.fundamentals.integration.visitors.Json2XmlConverter;
import java.io.File;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Json2XmlConverterTest {

  static final String JSON_FILE_NAME = "swagger_mailOut";
  static final String JSON_FILE = JSON_FILE_NAME + ".json";
  static final String XML_FILE = JSON_FILE_NAME + ".xml"; //integration
  static final String XML_FILE_PATH = "./src/test/resources/" + JSON_FILE_NAME + ".xml"; //integration

  private static String json;

  @BeforeAll
  static void setUp() {
    json = getFileAsString(JSON_FILE)
               .orElseThrow(() -> new RuntimeException("file " + JSON_FILE + " is not found in classpath"));

    final var xmlFile = new File(XML_FILE_PATH);
    if (!xmlFile.exists() || xmlFile.delete())
      Json2XmlConverter.writeOpenApiJsonAsXml(json, xmlFile);
  }

  @SneakyThrows
  @Test
  @DisplayName("Apply method works correctly")
  void applyMethodWorksCorrectlyTest() {

    assertThat(getFileAsString(XML_FILE))
        .isNotNull()
        .isNotEmpty()
        .hasValueSatisfying(
            xml -> assertThat(xml)
                       .startsWith(String.format("""
                               <?xml version="1.0" ?><%s xmlns="http://openapis.org/2" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://openapis.org/2 open-api-2.xsd" swagger="2.0">""",
                           "root")));
  }

}
