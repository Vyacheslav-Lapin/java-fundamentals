package pro.vlapin.courses.java.fundamentals.integration.json.entries;

//@SuperBuilder(toBuilder = true)
@SuppressWarnings({"unused", "java:S125"})
public class ArrayJsonEntry<T> /*extends ContainerJsonEntry<JsonEntry<T>>*/ {
//public class ArrayJsonEntry extends ContainerJsonEntry<JsonEntry<?>> {

//  @NotNull
//  @Contract(pure = true)
  //  public static <T> ArrayJsonEntry<T> from(@NotNull JsonParser jsonParser,
//  public static ArrayJsonEntry from(@NotNull JsonParser jsonParser,
//                                    @NotNull String name,
//                                    @Nullable JsonEntry<?>... entries) {

//    String entryName = getChildEntryName(name);
//
//    final var builder = ArrayJsonEntry.builder().key(name);
//    if (entries != null)
//      builder.values(List.of(entries));
//
//    JsonParser.Event event;
//    while ((event = jsonParser.next()) != END_ARRAY)
//      builder.value(getJsonEntry(entryName, jsonParser, event));
//    return init(builder.build());
//  }
//
//  @Override
//  public void visit(@NotNull JsonEntryVisitor jsonEntryVisitor) {
//    jsonEntryVisitor.accept(this);
//  }
//
//  @Override
//  public boolean isAttributePossible(JsonEntry<?> jsonEntry) {
//    return false;
//  }
//
}
