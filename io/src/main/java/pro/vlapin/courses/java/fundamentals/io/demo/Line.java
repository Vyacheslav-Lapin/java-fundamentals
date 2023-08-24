package pro.vlapin.courses.java.fundamentals.io.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Line {
  Point point1;
  Point point2;
  int index;
}
