package com.epam.courses.java.fundamentals.oop.practice.task6;

import com.epam.courses.java.fundamentals.oop.demo.superbuilder.Student;

import java.util.ArrayList;
import java.util.Objects;

public class Group {
  private Subject subject;
  private ArrayList<Student> studentsInGroup;

  public Group(Subject subject){
    this.subject = subject;
    studentsInGroup = new ArrayList<>();
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public ArrayList<Student> getStudentsInGroup() {
    return studentsInGroup;
  }

  public void addStudent(Student student){
    studentsInGroup.add(student);
    student.addGroup(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, studentsInGroup);
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == this)
      return true;
    if(obj == null || obj.getClass() != this.getClass())
      return false;
    Group group = (Group) obj;
    return this.subject == group.subject
        && this.studentsInGroup.equals(group.studentsInGroup);
  }
}
