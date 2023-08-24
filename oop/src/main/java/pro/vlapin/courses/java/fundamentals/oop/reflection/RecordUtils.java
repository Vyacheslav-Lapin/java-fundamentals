package pro.vlapin.courses.java.fundamentals.oop.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class RecordUtils {

  @SneakyThrows
  public <T extends Record> Constructor<T> canonicalConstructor(Class<T> aClass) {
    val paramTypes = Arrays.stream(aClass.getRecordComponents())
                      .map(RecordComponent::getType)
                      .toArray(Class<?>[]::new);
    return aClass.getDeclaredConstructor(paramTypes);
  }
}
