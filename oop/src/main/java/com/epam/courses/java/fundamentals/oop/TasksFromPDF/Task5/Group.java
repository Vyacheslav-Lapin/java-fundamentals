package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task5;

import java.util.Set;

public class Group {
    private final String name;
    private Set<Subject> subjects;
    private Set<Student> students;

    public Group(String name, Set<Subject> subjects, Set<Student> students) {
        this.name = name;
        this.students = students;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                ", students=" + students +
                '}';
    }
}
