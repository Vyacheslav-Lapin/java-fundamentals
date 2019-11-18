package com.epam.courses.java.fundamentals.jdbc.cp;

import static lombok.AccessLevel.NONE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Value;

@Value
//@AllArgsConstructor,
//@FieldDefaults(makeFinal = true, level = PRIVATE),
//@Getter
//@EqualsAndHashCode
//@ToString
@Getter(NONE)
public /*final*/ class ConnectionFactory implements Supplier<Connection> {

  String url;
  String user;
  String password;

  @Getter
  int poolSize;

  @Getter
  String initScriptsPath;

  @Override
  @SneakyThrows
  public Connection get() {
    return DriverManager.getConnection(url, user, password);
  }
}
