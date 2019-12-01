package com.epam.courses.java.fundamentals.oop.practice.task5;

/**
 * Разработайте приложение, позволяющее формировать группы студентов по разным дисциплинам.
 * Состав групп может быть разным. Каждая дисциплина в отдельности определяет,
 * целыми или вещественными будут оценки по ней.
 * Необходимо найти группы, в которые входит студент X, и сравнить его оценки.
 * Для организации перечня дисциплин можно использовать перечисление.
 */

public class Start {
  public static void main(String[] args) {

    Group vyshMat_lite = new Group(Group.Discipline.HIGHERMATH, Group.Tutor.PETROFF, true);
    Group vyshMat_adv = new Group(Group.Discipline.HIGHERMATH, Group.Tutor.KOUZNETSOFF, false);
    Group history = new Group(Group.Discipline.HISTORY, Group.Tutor.SMIRNOFF, true);
    Group numMeth = new Group(Group.Discipline.NUMMETHODS, Group.Tutor.IVANOFF, false);

    Student zuckermann = new Student("Abram Zuckermann", "z-IKTU-2017");
    Student tafiullin = new Student("Rustam Tafiullin", "o-FMS-2018");
    Student oganesyan = new Student("Aram Oganesyan", "z-IFPT-2018");
    Student karmanov = new Student("Igor Karmanov", "z-IKTU-2017");
    Student telegin = new Student("Maxim Telegin", "o-IFPT-2018");

    vyshMat_lite.addMark(zuckermann, 4.5).
        addMark(oganesyan, 3).
        addMark(zuckermann, 4).
        addMark(oganesyan, 5.0);
    vyshMat_adv.addMark(karmanov, 4.9).
        addMark(karmanov, 5).
        addMark(tafiullin, 4).
        addMark(telegin, 5.0);
    numMeth.addMark(karmanov, 4.8).
        addMark(tafiullin, 4.1).
        addMark(zuckermann, 3).
        addMark(zuckermann, 4.5);
    history.addMark(oganesyan, 3.5).
        addMark(oganesyan, 3.8).
        addMark(telegin, 4).
        addMark(karmanov, 4);

    System.out.println(karmanov.allGroups());

  }
}
