package com.epam.courses.java.fundamentals.integration;

import javax.json.stream.JsonParser;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface JsonXMLStreamReader extends XMLStreamReader, AutoCloseable {

  @NotNull
  @Contract("_ -> new")
  static JsonXMLStreamReader get(JsonParser jsonParser) {
    return new JsonXMLStreamReaderImpl(jsonParser);
  }

  @Override
  default Object getProperty(String name) throws IllegalArgumentException {
    return null;
  }

  @Override
  default void require(int type, String namespaceURI, String localName) throws XMLStreamException {
  }

  @Override
  default String getElementText() throws XMLStreamException {
    return null;
  }

  @Override
  default int nextTag() throws XMLStreamException {
    return 0;
  }

  @Override
  default void close() throws XMLStreamException {
  }

  @Override
  default String getNamespaceURI(String prefix) {
    return null;
  }

  @Override
  default boolean isStartElement() {
    return false;
  }

  @Override
  default boolean isEndElement() {
    return false;
  }

  @Override
  default boolean isCharacters() {
    return false;
  }

  @Override
  default boolean isWhiteSpace() {
    return false;
  }

  @Override
  default String getAttributeValue(String namespaceURI, String localName) {
    return null;
  }

  @Override
  default int getAttributeCount() {
    return 0;
  }

  @Override
  default QName getAttributeName(int index) {
    return null;
  }

  @Override
  default String getAttributeNamespace(int index) {
    return null;
  }

  @Override
  default String getAttributeLocalName(int index) {
    return null;
  }

  @Override
  default String getAttributePrefix(int index) {
    return null;
  }

  @Override
  default String getAttributeType(int index) {
    return null;
  }

  @Override
  default String getAttributeValue(int index) {
    return null;
  }

  @Override
  default boolean isAttributeSpecified(int index) {
    return false;
  }

  @Override
  default int getNamespaceCount() {
    return 0;
  }

  @Override
  default String getNamespacePrefix(int index) {
    return null;
  }

  @Override
  default String getNamespaceURI(int index) {
    return null;
  }

  @Override
  default NamespaceContext getNamespaceContext() {
    return null;
  }

  @Override
  default int getEventType() {
    return 0;
  }

  @Override
  default char[] getTextCharacters() {
    return new char[0];
  }

  @Override
  default int getTextCharacters(int sourceStart, char[] target, int targetStart, int length) throws XMLStreamException {
    return 0;
  }

  @Override
  default int getTextStart() {
    return 0;
  }

  @Override
  default int getTextLength() {
    return 0;
  }

  @Override
  default String getEncoding() {
    return null;
  }

  @Override
  default boolean hasText() {
    return false;
  }

  @Override
  default Location getLocation() {
    return null;
  }

  @Override
  default QName getName() {
    return null;
  }

  @Override
  default boolean hasName() {
    return false;
  }

  @Override
  default String getNamespaceURI() {
    return null;
  }

  @Override
  default String getPrefix() {
    return null;
  }

  @Override
  default String getVersion() {
    return null;
  }

  @Override
  default boolean isStandalone() {
    return false;
  }

  @Override
  default boolean standaloneSet() {
    return false;
  }

  @Override
  default String getCharacterEncodingScheme() {
    return null;
  }

  @Override
  default String getPITarget() {
    return null;
  }

  @Override
  default String getPIData() {
    return null;
  }
}
