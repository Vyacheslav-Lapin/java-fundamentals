package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
    private final String name;
    private Map<Subject, Number> subjects = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public void addSubjectAndGrade(Subject subject, Number grade) {
        subjects.put(subject,subject.gradeConverter(grade));
    }

    public String getName() {
        return name;
    }

    public Map<Subject, Number> getSubjectsAndGrades() {
        return subjects;
    }

    public Set<Subject> getSubjectsSet() {
        return new HashSet<Subject>(subjects.keySet());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
