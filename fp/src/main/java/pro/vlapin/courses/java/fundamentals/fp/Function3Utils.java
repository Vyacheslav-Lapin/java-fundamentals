package pro.vlapin.courses.java.fundamentals.fp;

import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function3;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Function3Utils {

  public <T1, T2, T3, R> Function0<R> supply(Function3<T1, T2, T3, R> self, T1 t1, T2 t2, T3 t3) {
    return () -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> Function1<T3, R> supply(Function3<T1, T2, T3, R> self, T1 t1, T2 t2) {
    return t3 -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> Function2<T2, T3, R> supply(Function3<T1, T2, T3, R> self, T1 t1) {
    return (t2, t3) -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> Function2<T1, T2, R> supplyRight(Function3<T1, T2, T3, R> self, T3 t3) {
    return (t1, t2) -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> Function1<T1, R> supplyRight(Function3<T1, T2, T3, R> self, T2 t2, T3 t3) {
    return t1 -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> Function2<T1, T3, R> supply2(Function3<T1, T2, T3, R> self, T2 t2) {
    return (t1, t3) -> self.apply(t1, t2, t3);
  }
}
