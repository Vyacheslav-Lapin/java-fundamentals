package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task5;

import java.util.*;

public class GroupBuilder {
    private Set<Group> groups = new HashSet<>();
    private Map<Student, List<Group>> students = new HashMap<>();

    public GroupBuilder(Set<Student> students) {
        for (Student student : students) {
            this.students.put(student, new ArrayList<Group>());
        }
    }

    public void createGroup(String name, Set<Subject> subjects) {
        Set<Student> studentSet = new HashSet<>();

        for (Student student : students.keySet())
            if (student.getSubjectsSet().containsAll(subjects))
                studentSet.add(student);

        Group formedGroup = new Group(name, new HashSet<Subject>(subjects), studentSet);
        groups.add(formedGroup);

        for (Student student : studentSet)
            students.get(student).add(formedGroup);
    }


    public List<Group> getStudentGroupList(Student student) {
        return new ArrayList<>(students.get(student));
    }
}
