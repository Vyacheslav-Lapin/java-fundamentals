package com.epam.courses.java.fundamentals.integration.json;

import static javax.json.stream.JsonParser.Event.START_ARRAY;
import static javax.json.stream.JsonParser.Event.START_OBJECT;

import io.vavr.Function2;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.json.stream.JsonParser;
import javax.xml.stream.XMLStreamException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public class JsonXMLStreamReaderImpl implements JsonXMLStreamReader {

  JsonParser jsonParser;

  Deque<Tuple2<JsonParser.Event, String>> events = new ArrayDeque<>();

  @Nullable
  private Tuple2<JsonParser.Event, String> getEvent() {
    JsonParser.Event event = jsonParser.next();
    val tuple2Draft = Function2
                    .<JsonParser.Event, String, Tuple2<JsonParser.Event, String>>of(Tuple::of)
                    .apply(event);
    return null;
  }

  @Override
  public int next() throws XMLStreamException {

    boolean isFirst = events.size() == 0;

    if (events.size() > 0) {
      val event = events.getFirst()._1;
      if (event != START_OBJECT && event != START_ARRAY)
        events.pop();
    }
    events.push(getEvent());

    return switch (events.getFirst()._1) {
      case START_OBJECT, START_ARRAY -> isFirst ? START_DOCUMENT : START_ELEMENT;
      case END_OBJECT, END_ARRAY -> jsonParser.hasNext() ? END_ELEMENT : END_DOCUMENT;
      case VALUE_STRING, VALUE_TRUE, VALUE_FALSE, VALUE_NUMBER, VALUE_NULL -> CHARACTERS;
      case KEY_NAME -> throw new RuntimeException("KEY_NAME is unexpected event in that phase");
    };
  }

  @Override
  public String getLocalName() {
//    switch (event) {

//      case START_OBJECT,
//               VALUE_STRING,
//               VALUE_NUMBER,
//               VALUE_TRUE,
//               VALUE_FALSE,
//               VALUE_NULL:
//        if ((event = jsonParser.next()) != KEY_NAME)
//          throw new RuntimeException("Unexpected event: " + event);

//      case KEY_NAME:
//        return jsonParser.getString();

//      case START_ARRAY, :
//        return "item";

//      default: return "";
//    }
    return null;
  }

  @Override
  public String getText() {
//    if (event == KEY_NAME)
//      event = jsonParser.next();
//
//    return switch (event) {
//      case VALUE_STRING, VALUE_NUMBER -> jsonParser.getString();
//      case VALUE_TRUE -> "true";
//      case VALUE_FALSE -> "false";
//      default -> "";
//    };
    return null;
  }

  @Override
  public boolean hasNext() throws XMLStreamException {
    return jsonParser.hasNext();
  }

  @Override
  public void close() {
    jsonParser.close();
  }
}
