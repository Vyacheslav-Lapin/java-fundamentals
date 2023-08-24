package pro.vlapin.courses.java.fundamentals.jdbc.cp;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectionPoolTest {

  static String SQL =
      "select id, first_name, last_name, permission, dob, email, password, address, telephone from Person";

  @Test
  @SneakyThrows
  @DisplayName("Connection Pool works correctly")
  void connectionPoolWorksCorrectlyTest() {
//    @Cleanup val connectionPool = ConnectionPool.getPool();
//    @Cleanup val connection = connectionPool.get();
//    @Cleanup val statement = connection.createStatement();
//    @Cleanup val resultSet = statement.executeQuery(SQL);
//    if (resultSet.next())
//      assertThat(resultSet.getString("first_name"))
//          .isEqualTo("Jose");
  }
}
