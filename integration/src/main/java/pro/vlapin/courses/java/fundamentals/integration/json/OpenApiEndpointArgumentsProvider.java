package pro.vlapin.courses.java.fundamentals.integration.json;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.util.LinkedHashMap;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class OpenApiEndpointArgumentsProvider implements ArgumentsProvider {

  public static void main(String... __) {
    DocumentContext documentContext = JsonPath.parse(
        OpenApiEndpointArgumentsProvider.class
            .getResourceAsStream("/swagger_mailOut.json"));
    LinkedHashMap<String, String> endPoints = documentContext.read("$.paths");
    System.out.println("endPoints = " + endPoints);
  }

  @Override
  @SneakyThrows
  public Stream<? extends Arguments> provideArguments(ExtensionContext __) {
    return null;
  }
}
