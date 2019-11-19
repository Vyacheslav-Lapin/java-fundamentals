import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

  private static final String DATABASE_URL = "jdbc:mysql://localhost/";

  private static final String USER = "alex";
  private static final String PASSWORD = "alex";

  public static void main(String[] args) throws SQLException {
    try(Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
      Database database = new Database();
      database.getAll(connection);
    }
  }

  private void insertInto(Connection connection) throws SQLException {
    Statement statement = connection.createStatement();
    String insertInto = "insert into users values('1', 'Alex', '25')";
    statement.executeUpdate(insertInto);
  }

  private void update(Connection connection) throws SQLException {
    Statement statement = connection.createStatement();
    String update = "update users set name 'vitya' where id = '1' and name = 'alex'";
    statement.executeUpdate(update);
  }

  private void getAll(Connection connection) throws SQLException {
    Statement statement = connection.createStatement();
    String getAll = "select*from users";
    statement.executeUpdate(getAll);
  }

  private void getConcreteField(Connection connection) throws SQLException {
    Statement statement = connection.createStatement();
    String get = "select name from users where id = 1";
    statement.executeUpdate(get);
  }

  private void deleteTable(Connection connection) throws SQLException {
    Statement statement = connection.createStatement();
    String get = "drop table users";
    statement.executeUpdate(get);
  }
}
