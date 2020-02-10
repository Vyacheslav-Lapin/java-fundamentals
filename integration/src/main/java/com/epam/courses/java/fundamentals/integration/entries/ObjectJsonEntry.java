package com.epam.courses.java.fundamentals.integration.entries;

import static javax.json.stream.JsonParser.Event.KEY_NAME;

import com.epam.courses.java.fundamentals.integration.visitors.JsonEntryVisitor;
import java.util.List;
import java.util.Set;
import javax.json.stream.JsonParser;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuperBuilder(toBuilder = true)
public class ObjectJsonEntry/*<T>*/ extends ContainerJsonEntry<JsonEntry</*T*/?>> {

  static Set<String> attributeNameSet = Set.of("xmlns", "xmlns:xsi", "xsi:schemaLocation");

  @NotNull
  @Contract(pure = true)
  public static /*<T>*/ ObjectJsonEntry/*<T>*/ from(@NotNull JsonParser jsonParser,
                                                    @NotNull String name,
                                                    @Nullable JsonEntry</*T*/?>... entries) {

    final var builder = ObjectJsonEntry.builder().key(name);

    if (entries != null)
      builder.values(List.of(entries));

    while (jsonParser.next() == KEY_NAME)
      builder.value(getJsonEntry(jsonParser.getString(), jsonParser));
    return init(builder.build());
  }

  @Override
  public void visit(@NotNull JsonEntryVisitor jsonEntryVisitor) {
    jsonEntryVisitor.accept(this);
  }

  @Override
  public boolean isAttributePossible(@NotNull JsonEntry<?> jsonEntry) {
//    List<JsonEntry<?>> attributes = getValues().stream()
//                                        .takeWhile(entry -> !(entry instanceof ContainerJsonEntry))
//                                        .filter(entry -> jsonEntry.getKey().equals(entry.getKey()))
//                                        .collect(Collectors.toUnmodifiableList());
//    return attributes.size() == 1 && attributes.contains(jsonEntry);
    return attributeNameSet.contains(jsonEntry.getKey());
  }

}
