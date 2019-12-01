package com.epam.courses.java.fundamentals.jdbc.cp;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectionPoolTest {

  static String SQL =
      "select id, first_name, last_name, permission, dob, email, password, address, telephone from Person";

  @SneakyThrows
  @Test
  @DisplayName("Connection Pool works correctly")
  void connectionPoolWorksCorrectlyTest() {
    @Cleanup var connectionPool = new ConnectionPool();
    @Cleanup var connection = connectionPool.get();
    @Cleanup var statement = connection.createStatement();
    @Cleanup var resultSet = statement.executeQuery(SQL);
    if (resultSet.next())
      assertThat(resultSet.getString("first_name"))
          .isEqualTo("Jose");
  }
}
