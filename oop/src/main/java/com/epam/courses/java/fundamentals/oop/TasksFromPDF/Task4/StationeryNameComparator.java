package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task4;


import com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task3.Stationery;

import java.util.Comparator;

public class StationeryNameComparator implements Comparator<Stationery> {

    @Override
    public int compare(Stationery obj1, Stationery obj2) {
        if (obj1 == obj2)
            return 0;
        if (obj1 == null || obj2 == null)
            return -1;

        return obj1.getName().compareTo(obj2.getName());
    }
}
