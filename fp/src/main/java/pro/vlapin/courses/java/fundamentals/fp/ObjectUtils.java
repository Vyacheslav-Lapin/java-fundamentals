package pro.vlapin.courses.java.fundamentals.fp;

import io.vavr.CheckedFunction1;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ObjectUtils {

  public <T, U> U map(T self, CheckedFunction1<? super T, ? extends U> mapper) {
    return mapper.unchecked().apply(self);
  }

  public <T> T doWith(T self, CheckedConsumer1<? super T> consumer) {
    consumer.unchecked().accept(self);
    return self;
  }

  public <T, U> Tuple2<T, U> withResult(T self, CheckedFunction1<? super T, ? extends U> mapper) {
    return Tuple.of(self, ObjectUtils.map(self, mapper));
  }
}
