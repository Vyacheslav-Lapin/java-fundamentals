package com.epam.courses.java.fundamentals.jdbc;

import java.sql.DriverManager;
import lombok.Builder;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

public class SimpleDemo {

  @Value
  @Builder
  @ToString
  @FieldNameConstants
  static class Student {
    Long id;
    String name;
    int groupId;
  }

  @SneakyThrows
  public static void main(String... __) {
    @Cleanup var connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    @Cleanup var statement = connection.createStatement();
    statement.executeUpdate("create table student (id identity, name varchar not null, group_id int)");
    statement.executeUpdate("insert into student (name, group_id) values ( 'Вася Пупкин', 123456 ), ('Федя Прокопов', 654321)");
    @Cleanup var resultSet = statement.executeQuery("select id, name, group_id as groupId from student");
    while (resultSet.next())
      System.out.println(
          Student.builder()
              .id(resultSet.getLong(Student.Fields.id))
              .name(resultSet.getString(Student.Fields.name))
              .groupId(resultSet.getInt(Student.Fields.groupId))
              .build());
  }
}
