package pro.vlapin.courses.java.fundamentals.integration.json.entries;

import pro.vlapin.courses.java.fundamentals.integration.json.visitors.JsonEntryVisitor;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuperBuilder(toBuilder = true)
public class NullJsonEntry extends JsonEntry<Object> {

  @Override
  @Nullable
  @Contract(pure = true)
  public Object getValue() {
    return null;
  }

  static NullJsonEntry from(String name) {
    return NullJsonEntry.builder().key(name).build();
  }

  @Override
  public void visit(@NotNull JsonEntryVisitor jsonEntryVisitor) {
    jsonEntryVisitor.accept(this);
  }
}
