package pro.vlapin.courses.java.fundamentals.strings;

import io.vavr.*;
import java.security.*;
import lombok.experimental.*;
import lombok.*;
import org.jetbrains.annotations.*;

@UtilityClass
@SuppressWarnings("unused")
public class EncryptUtil {

  private final String ALGORITHM = "MD5";

  private final MessageDigest ENCRYPTOR =
    CheckedFunction1.<String, MessageDigest>of(MessageDigest::getInstance)
      .unchecked()
      .apply(ALGORITHM);

  @NotNull
  @SuppressWarnings("unused")
  public String encrypt(@NotNull String s) {

    ENCRYPTOR.reset();

    val bs = ENCRYPTOR.digest(s.getBytes());

    val stringBuilder = new StringBuilder();

    //hex encode the digest
    for (byte b : bs) {
      String hexVal = Integer.toHexString(0xFF & b);
      if (hexVal.length() == 1)
        stringBuilder.append("0");
      stringBuilder.append(hexVal);
    }

    return stringBuilder.toString();
  }
}
