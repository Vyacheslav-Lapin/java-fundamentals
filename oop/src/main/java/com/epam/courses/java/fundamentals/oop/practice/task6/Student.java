package com.epam.courses.java.fundamentals.oop.practice.task6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student {

  String name;

  Map<Subject, ArrayList<Double>> subjects = new HashMap<>(7);

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Set<Subject> getSubjects() {
    return subjects.keySet();
  }

  public void addSubject(Subject subject) {
    subjects.put(subject, new ArrayList<>());
  }

  public void addMark(Subject subject, Double mark) {
    if (subject.isMarkInteger())
      throw new RuntimeException("Mark has to be integer");
    else if (!subjects.containsKey(subject))
      throw new RuntimeException("Student doesn't have this subject");
    else
      subjects.get(subject).add(mark);
  }

  public void addMark(Subject subject, Integer mark) {
    if (!subject.isMarkInteger())
      throw new RuntimeException("Mark has to be double");
    else if (!subjects.containsKey(subject))
      throw new RuntimeException("Student doesn't have this subject");
    else
      subjects.get(subject).add((double) mark);
  }

  public void showMarks(Subject sub) {
    if (sub.isMarkInteger()) {
      for (double elem : subjects.get(sub)) {
        int mark = (int) elem;
        System.out.print(mark + " ");
      }
    } else
      System.out.println(subjects.get(sub));
  }

  public void compareMarks() {
    int count = 0;
    double sum = 0;
    double average;
    double max = 0;
    Subject maxSub = null;
    Set<Subject> set = getSubjects();
    for (Subject sub : set) {
      for (double m : subjects.get(sub)) {
        sum += m;
        count++;
      }
      average = sum / count;
      if(average > max ){
        max = average;
        maxSub = sub;
      }
      sum = 0;
      count = 0;
    }
    System.out.println("Best subject is " + maxSub + " average is " + max );
  }
}
