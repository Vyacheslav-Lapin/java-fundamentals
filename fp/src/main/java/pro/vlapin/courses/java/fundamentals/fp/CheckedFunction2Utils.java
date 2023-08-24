package pro.vlapin.courses.java.fundamentals.fp;

import io.vavr.CheckedFunction0;
import io.vavr.CheckedFunction1;
import io.vavr.CheckedFunction2;
import lombok.experimental.UtilityClass;

/**
 * CheckedFunction2Utils.
 *
 * @author Vyacheslav Lapin
 */
//todo: 02.03.2023: substitute "CheckedFunction2Utils" with correct description in above javadoc
@UtilityClass
public class CheckedFunction2Utils {

  public <T, T1, T2, R> CheckedFunction2<T, T2, R> compose1(CheckedFunction2<T1, T2, R> self, CheckedFunction1<T, T1> composer) {
    return (t, t2) -> self.apply(composer.apply(t), t2);
  }

  public <T, T1, T2, R> CheckedFunction2<T1, T, R> compose2(CheckedFunction2<T1, T2, R> self, CheckedFunction1<T, T2> composer) {
    return (t1, t) -> self.apply(t1, composer.apply(t));
  }

  public <T1, T2, R> CheckedFunction1<T1, R> apply2(CheckedFunction2<T1, T2, R> self, T2 t2) {
    return t1 -> self.apply(t1, t2);
  }

  public <T1, T2, R> CheckedFunction1<T1, R> applyRight(CheckedFunction2<T1, T2, R> self, T2 t2) {
    return t1 -> self.apply(t1, t2);
  }

  public <T1, T2, R> CheckedFunction1<T2, R> supply(CheckedFunction2<T1, T2, R> self, CheckedFunction0<T1> supplier) {
    return t2 -> self.apply(supplier.apply(), t2);
  }

  public <T1, T2, R>  CheckedFunction0<R> supply(CheckedFunction2<T1, T2, R> self, T1 t1, T2 t2) {
    return () -> self.apply(t1, t2);
  }
}
