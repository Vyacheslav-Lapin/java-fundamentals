package pro.vlapin.courses.java.fundamentals.fp;

import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import java.util.function.Function;
import lombok.experimental.UtilityClass;

/**
 * Function2Utils.
 *
 * @author Vyacheslav Lapin
 */
//todo: 02.03.2023: substitute "Function2Utils" with correct description in above javadoc
@UtilityClass
public class Function2Utils {

  public <T, T1, T2, R> Function2<T, T2, R> compose1(Function2<T1, T2, R> self, Function<T, T1> composer) {
    return (t, t2) -> self.apply(composer.apply(t), t2);
  }

  public <T, T1, T2, R> Function2<T1, T, R> compose2(Function2<T1, T2, R> self, Function<T, T2> composer) {
    return (t1, t) -> self.apply(t1, composer.apply(t));
  }

  public <T1, T2, R> Function1<T2, R> supply(Function2<T1, T2, R> self, Function0<T1> supplier) {
    return t2 -> self.apply(supplier.apply(), t2);
  }
}
