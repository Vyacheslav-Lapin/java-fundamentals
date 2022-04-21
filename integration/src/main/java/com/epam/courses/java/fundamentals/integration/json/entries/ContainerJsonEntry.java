package com.epam.courses.java.fundamentals.integration.json.entries;

import com.epam.courses.java.fundamentals.integration.json.ImpossibleValueException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;
import java.util.List;
import javax.json.Json;
import javax.json.stream.JsonParser;
import lombok.Getter;
import lombok.Singular;
import lombok.SneakyThrows;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//@SuperBuilder
public abstract class ContainerJsonEntry<T extends JsonEntry<?>>/* extends JsonEntry<Collection<T>> */{

//  @Getter
//  @Singular
//  List<T> values;

//  @NotNull
//  public static <T1, T2 extends JsonEntry<T1>, T3 extends ContainerJsonEntry<T2>> T3 from(String json,
//                                                                                          String rootEntryName,
//                                                                                          JsonEntry<?>... entries) {
//    return from(new StringReader(json), rootEntryName, entries);
//  }
//
//  @NotNull
//  @SneakyThrows
//  public static <T1, T2 extends JsonEntry<T1>, T3 extends ContainerJsonEntry<T2>> T3 from(Reader jsonReader,
//                                                                                          String rootEntryName,
//                                                                                          JsonEntry<?>... entries) {
//    try (jsonReader;
//         final var jsonParser = Json.createParser(jsonReader)) {
//      //noinspection unchecked
//      return (T3) switch (jsonParser.next()) {
//        case START_OBJECT -> ObjectJsonEntry.from(jsonParser, rootEntryName, entries);
//        case START_ARRAY -> ArrayJsonEntry.from(jsonParser, rootEntryName, entries);
//        default -> throw new ImpossibleValueException();
//      };
//    }
//  }
//
//  @Nullable
//  protected static <T, U extends JsonEntry<T>> U getJsonEntry(@NotNull String name,
//                                                              @NotNull JsonParser jsonParser) {
//    return getJsonEntry(name, jsonParser, jsonParser.next());
//  }
//
//  @Nullable
//  protected static <T, U extends JsonEntry<T>> U getJsonEntry(@NotNull String name,
//                                                              @NotNull JsonParser jsonParser,
//                                                              @NotNull JsonParser.Event event) {
//    noinspection unchecked
//    return (U) switch (event) {
//      case START_OBJECT -> ObjectJsonEntry.from(jsonParser, name);
//      case START_ARRAY -> ArrayJsonEntry.from(jsonParser, name);
//      case VALUE_STRING -> StringJsonEntry.from(jsonParser.getString(), name);
//      case VALUE_TRUE -> BooleanJsonEntry.from(true, name);
//      case VALUE_FALSE -> BooleanJsonEntry.from(false, name);
//      case VALUE_NULL -> NullJsonEntry.from(name);
//      case VALUE_NUMBER -> NumberJsonEntry.from(Double.parseDouble(jsonParser.getString()), name);
//      case END_ARRAY, END_OBJECT -> null;
//      default -> throw new RuntimeException("Impossible value!");
//    };
//  }
//
//  @NotNull
//  public static <T extends ContainerJsonEntry<?>> T init(@NotNull T containerJsonEntry) {
//
//    containerJsonEntry.getValues()
//        .forEach(jsonEntry -> jsonEntry.setParent(containerJsonEntry));
//
//    return containerJsonEntry;
//  }
//
//  @NotNull
//  public static String getChildEntryName(@NotNull String name) {
//    return name.endsWith("ies") ? name.substring(0, name.length() - 3) + 'y' :
//               name.endsWith("s") ? name.substring(0, name.length() - 1) : "item";
//  }
//
//  @Override
//  public Collection<T> getValue() {
//    return values;
//  }
//
//  public abstract boolean isAttributePossible(JsonEntry<?> jsonEntry);
}
