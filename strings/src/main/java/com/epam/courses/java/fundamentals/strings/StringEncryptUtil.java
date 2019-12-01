package com.epam.courses.java.fundamentals.strings;

import io.vavr.CheckedFunction1;
import java.security.MessageDigest;
import lombok.val;
import org.jetbrains.annotations.NotNull;

public interface StringEncryptUtil {

  String ALGORITHM = "MD5";

  @SuppressWarnings("SpellCheckingInspection")
  MessageDigest ENCRYPTOR =
    CheckedFunction1.<String, MessageDigest>of(MessageDigest::getInstance)
      .unchecked()
      .apply(ALGORITHM);

  @NotNull
  static String encrypt(@NotNull String s) {

    ENCRYPTOR.reset();

    byte[] bs = ENCRYPTOR.digest(s.getBytes());

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
