package pro.vlapin.courses.java.fundamentals.fp;

import io.vavr.CheckedFunction1;
import io.vavr.CheckedFunction2;
import io.vavr.CheckedFunction3;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CheckedFunction3Utils {

  public <T1, T2, T3, R> CheckedFunction0<R> supply(CheckedFunction3<T1, T2, T3, R> self, T1 t1, T2 t2, T3 t3) {
    return () -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> CheckedFunction1<T3, R> supply(CheckedFunction3<T1, T2, T3, R> self, T1 t1, T2 t2) {
    return t3 -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> CheckedFunction2<T2, T3, R> supply(CheckedFunction3<T1, T2, T3, R> self, T1 t1) {
    return (t2, t3) -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> CheckedFunction2<T1, T2, R> supplyRight(CheckedFunction3<T1, T2, T3, R> self, T3 t3) {
    return (t1, t2) -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> CheckedFunction1<T1, R> supplyRight(CheckedFunction3<T1, T2, T3, R> self, T2 t2, T3 t3) {
    return t1 -> self.apply(t1, t2, t3);
  }

  public <T1, T2, T3, R> CheckedFunction2<T1, T3, R> supply2(CheckedFunction3<T1, T2, T3, R> self, T2 t2) {
    return (t1, t3) -> self.apply(t1, t2, t3);
  }
}
