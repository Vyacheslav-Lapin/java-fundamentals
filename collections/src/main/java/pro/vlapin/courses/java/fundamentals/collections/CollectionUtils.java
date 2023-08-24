package pro.vlapin.courses.java.fundamentals.collections;

import java.util.Iterator;
import java.util.stream.Stream;
import lombok.experimental.UtilityClass;

import static java.util.Spliterator.*;
import static java.util.Spliterators.*;
import static java.util.stream.StreamSupport.*;

@UtilityClass
public class CollectionUtils {

  public <T> Stream<T> toStream(Iterator<T> iterator) {
    return stream(spliteratorUnknownSize(iterator, ORDERED), false);
  }
}
