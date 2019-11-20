package com.epam.courses.java.fundamentals.oop.demo.superbuilder;


import com.epam.courses.java.fundamentals.oop.practice.task6.Group;
import com.epam.courses.java.fundamentals.oop.practice.task6.Mark;
import com.epam.courses.java.fundamentals.oop.practice.task6.Subject;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.print.attribute.standard.JobKOctets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Getter
@SuperBuilder
public class Student extends Child {
  private String schoolName;
  private HashMap<Subject, Mark> subjectsAndMarks;
  private ArrayList<Group> groups;

  public Student(String parentName, int parentAge, String childName, int childAge, String schoolName){
    super(parentName, parentAge, childName, childAge);
    this.schoolName = schoolName;
    subjectsAndMarks = new HashMap<>();
    groups = new ArrayList<>();
  }

  @Override
  public String getParentName() {
    return super.getParentName();
  }

  @Override
  public int getParentAge() {
    return super.getParentAge();
  }

  @Override
  public String getChildName() {
    return super.getChildName();
  }

  @Override
  public int getChildAge() {
    return super.getChildAge();
  }

  public String getSchoolName() {
    return schoolName;
  }

  public HashMap<Subject, Mark> getSubjectsAndMarks() {
    return subjectsAndMarks;
  }

  public ArrayList<Group> getGroups() {
    return groups;
  }

  public void addSubjectAndMark(Subject subject, Mark mark){
    subjectsAndMarks.put(subject,mark);
  }

  public void addGroup(Group group){
    groups.add(group);
    group.addStudent(this);
  }

  public void compareMarks(Student student, Subject subject){
    if(subjectsAndMarks.containsKey(subject)){
      System.out.println("You mark: " + subjectsAndMarks.get(subject) + " vs mark: " + student.getSubjectsAndMarks().get(subject));
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(parentName, parentAge, childName, childAge, schoolName, groups );
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == this)
      return true;
    if(obj == null || this.getClass() != obj.getClass())
      return false;
    Student student = (Student) obj;
    return this.parentName.equals(student.parentName)
        && this.parentAge == student.parentAge
        && this.childName.equals(student.childName)
        && this.schoolName.equals(student.schoolName)
        && this.groups.equals(student.groups);
  }

  @Override
  public String toString() {
    return "Name: " + childName +"\nAge: " + childAge + "\nParent name: " + parentName
        + "\nParent age: " + parentAge + "\nSchool name: " + schoolName
        + "\nDisciplines: ";
  }

}
