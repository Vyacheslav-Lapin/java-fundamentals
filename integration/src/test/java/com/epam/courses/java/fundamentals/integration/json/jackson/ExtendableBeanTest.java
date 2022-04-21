package com.epam.courses.java.fundamentals.integration.json.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExtendableBeanTest {

  static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Test
  @SneakyThrows
  @DisplayName("Serializing using JsonAnyGetter")
  void serializingUsingJsonAnyGetterTest() {

    assertThat(
        OBJECT_MAPPER.writeValueAsString(
            ExtendableBean.builder()
                .name("My bean")
                .property("attr1", "val1")
                .property("attr2", "val2")
                .build()))
        .isEqualTo("{\"name\":\"My bean\",\"attr1\":\"val1\",\"attr2\":\"val2\"}");

    assertThat(OBJECT_MAPPER.readValue("""
        {
          "name": "My bean",
          "attr2": "val2",
          "attr1": "val1"
        }""", ExtendableBean.class))
        .matches(extendableBean -> extendableBean.getName().equals("My bean"))
        .extracting(ExtendableBean::getProperties)
        .hasFieldOrPropertyWithValue("attr2", "val2")
        .hasFieldOrPropertyWithValue("attr1", "val1");
  }
}
