package com.epam.courses.java.fundamentals.integration.entries;

import static javax.json.stream.JsonParser.Event.END_ARRAY;

import com.epam.courses.java.fundamentals.integration.visitors.JsonEntryVisitor;
import java.util.List;
import javax.json.stream.JsonParser;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuperBuilder(toBuilder = true)
//public class ArrayJsonEntry<T> extends ContainerJsonEntry<JsonEntry<T>> {
public class ArrayJsonEntry extends ContainerJsonEntry<JsonEntry<?>> {

  @NotNull
  @Contract(pure = true)
  //  public static <T> ArrayJsonEntry<T> from(@NotNull JsonParser jsonParser,
  public static ArrayJsonEntry from(@NotNull JsonParser jsonParser,
                                    @NotNull String name,
                                    @Nullable JsonEntry<?>... entries) {

    String entryName = getChildEntryName(name);

    final var builder = ArrayJsonEntry.builder().key(name);
    if (entries != null)
      builder.values(List.of(entries));

    JsonParser.Event event;
    while ((event = jsonParser.next()) != END_ARRAY)
      builder.value(getJsonEntry(entryName, jsonParser, event));
    return init(builder.build());
  }

  @Override
  public void visit(@NotNull JsonEntryVisitor jsonEntryVisitor) {
    jsonEntryVisitor.accept(this);
  }

  @Override
  public boolean isAttributePossible(JsonEntry<?> jsonEntry) {
    return false;
  }

}
