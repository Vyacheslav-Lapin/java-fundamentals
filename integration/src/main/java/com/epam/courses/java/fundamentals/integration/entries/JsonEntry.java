package com.epam.courses.java.fundamentals.integration.entries;

import com.epam.courses.java.fundamentals.integration.visitors.JsonEntryVisitor;
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
