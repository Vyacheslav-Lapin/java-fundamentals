package com.epam.courses.java.fundamentals.integration.json.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ExtendableBean {

  String name;

  @Singular
  @JsonAnySetter
//  @Getter(onMethod_ = @JsonAnyGetter)
//  @Getter(onMethod = @__(@JsonAnyGetter))
  Map<String, String> properties;

  @JsonAnyGetter
  public Map<String, String> getProperties() {
    return properties;
  }
}
