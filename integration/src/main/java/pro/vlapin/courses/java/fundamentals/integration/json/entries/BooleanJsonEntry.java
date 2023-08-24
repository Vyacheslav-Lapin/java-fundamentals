package pro.vlapin.courses.java.fundamentals.integration.json.entries;

import pro.vlapin.courses.java.fundamentals.integration.json.visitors.JsonEntryVisitor;
import java.util.function.BooleanSupplier;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

@SuperBuilder(toBuilder = true)
public class BooleanJsonEntry extends JsonEntry<Boolean> implements BooleanSupplier {

  boolean value;

  static BooleanJsonEntry from(boolean value,
                               @NotNull String name) {
    return BooleanJsonEntry.builder()
               .key(name)
               .value(value)
               .build();
  }

  @Override
  public Boolean getValue() {
    return value;
  }

  @Override
  public boolean getAsBoolean() {
    return value;
  }

  @Override
  public void visit(@NotNull JsonEntryVisitor jsonEntryVisitor) {
    jsonEntryVisitor.accept(this);
  }
}
