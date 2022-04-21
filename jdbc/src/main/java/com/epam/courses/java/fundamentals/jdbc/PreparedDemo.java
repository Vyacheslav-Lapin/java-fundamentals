package com.epam.courses.java.fundamentals.jdbc;

import java.sql.DriverManager;
import lombok.Builder;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
//@UtilityClass
public class PreparedDemo {

  @SneakyThrows
  public static void main(String... __) {
    @Cleanup val connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");

    @Cleanup val statement = connection.createStatement();
    statement.executeUpdate("create table student (id identity, name varchar not null, group_id int)");

    @Cleanup val ps = connection.prepareStatement("insert into student (name, group_id) values (?,?)");

    ps.setString(1, "Вася Пупкин");
    ps.setInt(2, 123456);
    ps.executeUpdate();

    ps.setString(1, "Федя Прокопов");
    ps.setInt(2, 654321);
    ps.executeUpdate();

    @Cleanup val resultSet = statement.executeQuery("select id, name, group_id as groupId from student");
    while (resultSet.next())
      System.out.println(
          Student.builder()
              .id(resultSet.getLong(Student.Fields.id))
              .name(resultSet.getString(Student.Fields.name))
              .groupId(resultSet.getInt(Student.Fields.groupId))
              .build());
  }

  @Value
  @Builder
  @FieldNameConstants
  static class Student {
    Long id;
    String name;
    int groupId;
  }
}
