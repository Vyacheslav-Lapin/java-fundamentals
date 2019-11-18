package com.epam.courses.java.fundamentals.jdbc.cp;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectionPoolTest {

  static String SQL =
      "select id, first_name, last_name, permission, dob, email, password, address, telephone from Person";

  @Test
  @Disabled
  @SneakyThrows
  @DisplayName("Get method works correctly")
  void get() {
    @Cleanup val connectionPool = new ConnectionPool();
    @Cleanup val connection = connectionPool.get();
    @Cleanup val statement = connection.createStatement();
    @Cleanup val resultSet = statement.executeQuery(SQL);
    if (resultSet.next())
      assertThat(resultSet.getString("first_name"))
          .isEqualTo("Jose");
  }

//  @Test
//  @SneakyThrows
//  @DisplayName("TestGet method works correctly")
//  void TestGet() {
//  }
}
