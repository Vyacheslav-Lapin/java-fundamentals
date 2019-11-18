package com.epam.courses.java.fundamentals.oop.practice.task2;

import com.epam.courses.java.fundamentals.oop.demo.Employee;

public class CreateStarterPack {
  public static void main(String[] args) {
    Employee employee = new Employee("Nikita",20,184,50_000);
    Pen pen = new Pen(1,200,"pilot","PILOT",typesOfPen.BALLPOINT);
    Paper paper = new Paper(20,7,"EPAM systems","SvetoCopy");
    Pencil pencil = new Pencil(40,"EPAM Systems","KHOR",2,typesOfPencil.GRAPHITE);
    Ruler ruler = new Ruler(80,"EPAM systems","GRpro",20,materialForRuler.WOOD);
    employee.addPen(pen);
    employee.addPaper(paper);
    employee.addPencil(pencil);
    employee.addRuler(ruler);
    employee.showAllStuf();
  }
}
