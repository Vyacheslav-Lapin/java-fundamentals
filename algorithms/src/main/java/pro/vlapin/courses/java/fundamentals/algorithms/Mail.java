package pro.vlapin.courses.java.fundamentals.algorithms;

import lombok.experimental.UtilityClass;
import lombok.val;

/**
 * В почтовом ящике лежат письма. Некоторые из них требуется прочитать.
 * Если письмо новое - оно должно быть прочитано вместе с предыдущим (ответом на которое оно является),
 * даже если предыдущее <b>уже было прочитано</b>. Остальные прочитанные письма читать не нужно.
 * Информация о прочитанных письмах передаётся в виде числа 0, о непрочитанных - в виде числа 1. Требуется
 * написать метод, вычисляющий - сколько писем придётся прочесть.
 */
@UtilityClass
public class Mail {

  public int howMatchToRead(int... ar) {
    var result = 0;
    var isPreviousNew = false;

    if (ar.length > 0)
      for (val mail : ar) {
        val isNew = mail == 1;
        if (isNew || isPreviousNew)
          result++;
        isPreviousNew = isNew;
      }

    return result;
  }
}
