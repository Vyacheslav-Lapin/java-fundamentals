package pro.vlapin.courses.java.fundamentals.integration.xml.jaxb;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import static pro.vlapin.courses.java.fundamentals.integration.xml.jaxb.Food.Fields.*;
import static jakarta.xml.bind.annotation.XmlAccessType.*;
import static lombok.AccessLevel.*;

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
