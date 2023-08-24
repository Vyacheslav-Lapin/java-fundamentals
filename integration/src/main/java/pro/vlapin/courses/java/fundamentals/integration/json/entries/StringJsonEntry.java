package pro.vlapin.courses.java.fundamentals.integration.json.entries;

import pro.vlapin.courses.java.fundamentals.integration.json.visitors.JsonEntryVisitor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

@Getter
@SuperBuilder(toBuilder = true)
public class StringJsonEntry extends JsonEntry<String> implements Comparable<JsonEntry<?>> {

  String value;

  @NotNull
  static StringJsonEntry from(@NotNull String value,
                              @NotNull String name) {

    return StringJsonEntry.builder()
               .key(name)
               .value(value)
               .build();
  }

  @Override
  public void visit(@NotNull JsonEntryVisitor jsonEntryVisitor) {
    jsonEntryVisitor.accept(this);
  }

  @Override
  public int compareTo(@NotNull JsonEntry<?> o) {
    return o instanceof StringJsonEntry ? 0 : 1;
  }
}
