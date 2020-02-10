package com.epam.courses.java.fundamentals.integration.visitors;

import static com.epam.courses.java.fundamentals.integration.entries.ContainerJsonEntry.getChildEntryName;
import static com.epam.courses.java.fundamentals.integration.entries.ContainerJsonEntry.init;

import com.epam.courses.java.fundamentals.integration.entries.ArrayJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.BooleanJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.ContainerJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.JsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.NullJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.NumberJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.ObjectJsonEntry;
import com.epam.courses.java.fundamentals.integration.entries.StringJsonEntry;
import com.epam.courses.java.fundamentals.io.OutputStreamUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class Json2XmlConverter implements JsonEntryVisitor {

  XMLStreamWriter xmlStreamWriter;

  @NotNull
  public static String openApiJsonToXml(@NotNull String json) {
    return OutputStreamUtils.fromPrintStream(
        printStream -> writeOpenApiJsonAsXml(json, printStream));
  }

  public static void writeOpenApiJsonAsXml(String json, String xmlFileName) {
    writeOpenApiJsonAsXml(json, new File(xmlFileName));
  }

  @SneakyThrows
  public static void writeOpenApiJsonAsXml(String json, File xmlFile) {
    try (final var fileOutputStream = new FileOutputStream(xmlFile);
         final var bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
      writeOpenApiJsonAsXml(json, bufferedOutputStream);
    }
  }

  @SneakyThrows
  public static void writeOpenApiJsonAsXml(String json, OutputStream printStream) {
    writeAsXml(
        json,
        "root",
        printStream,
        StringJsonEntry.builder().key("xmlns").value("http://openapis.org/2").build(),
        StringJsonEntry.builder().key("xmlns:xsi").value("http://www.w3.org/2001/XMLSchema-instance").build(),
        StringJsonEntry.builder().key("xsi:schemaLocation").value("http://openapis.org/2 open-api-2.xsd").build());
  }

  @NotNull
  @SneakyThrows
  @Contract(pure = true)
  public static String toXml(String json, String rootTagName, JsonEntry<?>... entries) {

    return OutputStreamUtils.fromPrintStream(
        printStream -> writeAsXml(json, rootTagName, printStream, entries));
  }

  public static void writeAsXml(String json,
                                String rootTagName,
                                OutputStream printStream,
                                JsonEntry<?>... entries) throws XMLStreamException {

    val containerEntity = ContainerJsonEntry.from(json, rootTagName, entries);

    val xmlStreamWriter = XMLOutputFactory.newInstance()
                              .createXMLStreamWriter(printStream);

    xmlStreamWriter.writeStartDocument();

    containerEntity.visit(new Json2XmlConverter(xmlStreamWriter));

    xmlStreamWriter.writeEndDocument();
    xmlStreamWriter.flush();
  }

  @Override
  @SneakyThrows
  public void accept(@NotNull ObjectJsonEntry jsonEntry) {

    final var key = jsonEntry.getKey();

    if (!jsonEntry.isRoot()
            && jsonEntry.getParent().getKey().equals("properties")
            && !jsonEntry.getKey().equals("property"))
      init(ObjectJsonEntry.builder()
               .key(getChildEntryName(jsonEntry.getParent().getKey()))
               .value(StringJsonEntry.builder().key("name").value(key).build())
               .values(jsonEntry.getValues())
               .parent(jsonEntry.getParent())
               .build())
          .visit(this);
    else if (key.startsWith("/")
                 || key.matches("[1-5]\\d{2}")
                 || Character.isUpperCase(key.charAt(0))
    )
      init(ObjectJsonEntry.builder()
               .key(getChildEntryName(jsonEntry.getParent().getKey()))
               .value(StringJsonEntry.builder().key("value").value(key).build())
               .values(jsonEntry.getValues())
               .parent(jsonEntry.getParent())
               .build())
          .visit(this);
    else {
      xmlStreamWriter.writeStartElement(key);
      jsonEntry.getValues()
          .forEach(entry -> entry.visit(this));
      xmlStreamWriter.writeEndElement();
    }
  }

  @Override
  @SneakyThrows
  public void accept(@NotNull ArrayJsonEntry jsonEntry) {
    xmlStreamWriter.writeStartElement(jsonEntry.getKey());
    jsonEntry.getValues()
        .forEach(entry -> entry.visit(this));
    xmlStreamWriter.writeEndElement();
  }

  @Override
  @SneakyThrows
  public void accept(@NotNull StringJsonEntry jsonEntry) {
    //todo 13.01.2020: когда прикрутим поддержку схем, сравнить с дефольтным значением по схеме и не писать, если совпадает
    String key = jsonEntry.getKey();
    if (key.startsWith("$"))
      key = key.substring(1);// jsonEntry.toBuilder().key(key.substring(1)).build().visit(this);
    if (jsonEntry.getParent().isAttributePossible(jsonEntry))
      xmlStreamWriter.writeAttribute(key, jsonEntry.getValue());
    else {
      xmlStreamWriter.writeStartElement(key);
      xmlStreamWriter.writeCharacters(jsonEntry.getValue());
      xmlStreamWriter.writeEndElement();
    }
  }

  @Override
  @SneakyThrows
  public void accept(@NotNull BooleanJsonEntry jsonEntry) {
    //todo 13.01.2020: когда прикрутим поддержку схем, сравнить с дефольтным значением по схеме и не писать, если совпадает
//    if (jsonEntry.getParent().isAttributePossible(jsonEntry))
//      xmlStreamWriter.writeAttribute(jsonEntry.getKey(), Boolean.toString(jsonEntry.getAsBoolean()));
//    else {
      xmlStreamWriter.writeStartElement(jsonEntry.getKey());
      xmlStreamWriter.writeCharacters(Boolean.toString(jsonEntry.getAsBoolean()));
      xmlStreamWriter.writeEndElement();
//    }
  }

  @Override
  @SneakyThrows
  public void accept(@NotNull NumberJsonEntry jsonEntry) {
    //todo 13.01.2020: когда прикрутим поддержку схем, сравнить с дефольтным значением по схеме и не писать, если совпадает
//    if (jsonEntry.getParent().isAttributePossible(jsonEntry))
//      xmlStreamWriter.writeAttribute(jsonEntry.getKey(), Double.toString(jsonEntry.getAsDouble()));
//    else {
      xmlStreamWriter.writeStartElement(jsonEntry.getKey());
      xmlStreamWriter.writeCharacters(Double.toString(jsonEntry.getAsDouble()));
      xmlStreamWriter.writeEndElement();
//    }
  }

  @Override
  @SneakyThrows
  public void accept(@NotNull NullJsonEntry jsonEntry) {
    //todo 13.01.2020: когда прикрутим поддержку схем, сравнить с дефольтным значением по схеме и не писать, если совпадает
//    if (jsonEntry.getParent().isAttributePossible(jsonEntry))
//      xmlStreamWriter.writeAttribute(jsonEntry.getKey(), "");
//    else {
      xmlStreamWriter.writeStartElement(jsonEntry.getKey());
      xmlStreamWriter.writeCharacters("null");
      xmlStreamWriter.writeEndElement();
//    }
  }
}
