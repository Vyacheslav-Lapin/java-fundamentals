package com.epam.courses.java.fundamentals.integration.xml.jaxb;

import static com.epam.courses.java.fundamentals.integration.xml.jaxb.Food.Fields.name;
import static com.epam.courses.java.fundamentals.integration.xml.jaxb.Food.Fields.price;
import static com.epam.courses.java.fundamentals.integration.xml.jaxb.Food.Fields.description;
import static com.epam.courses.java.fundamentals.integration.xml.jaxb.Food.Fields.calories;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;
import static lombok.AccessLevel.PRIVATE;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

@Value
@XmlRootElement
@XmlAccessorType(FIELD)
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor(access = PRIVATE)
@XmlType(propOrder = {name, price, description, calories})
//@XmlType(propOrder = {"name", "price", "description", "calories"})
@FieldNameConstants
public class Food {

  @XmlAttribute(required = true)
  int id;

  String name;
  String price;
  String description;
  int calories;
}
