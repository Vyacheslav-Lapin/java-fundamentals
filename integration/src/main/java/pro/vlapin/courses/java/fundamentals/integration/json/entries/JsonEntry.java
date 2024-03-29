package pro.vlapin.courses.java.fundamentals.integration.json.entries;

import pro.vlapin.courses.java.fundamentals.integration.json.visitors.JsonEntryVisitor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public abstract class JsonEntry<T> {

  String key;

  @NonFinal
  ContainerJsonEntry<?> parent;

  public abstract void visit(JsonEntryVisitor jsonEntryVisitor);

  public abstract T getValue();

  public boolean isRoot() {
    return parent == null;
  }

}
