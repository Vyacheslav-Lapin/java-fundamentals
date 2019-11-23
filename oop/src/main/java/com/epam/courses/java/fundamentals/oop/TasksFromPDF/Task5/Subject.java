package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task5;

import java.text.MessageFormat;

public enum  Subject {

    PHYSICS(1,5,true),
    MATH(1,5, true),
    CHEMISTRY(1,5, true),
    ENGLISH(0.1,10, false),
    HISTORY(0.1, 10, false);


    private final double minGrade;
    private final double maxGrade;
    private final boolean isInteger;


    Subject(double minGrade, double maxGrade, boolean isInteger) {
        this.minGrade = minGrade;
        this.maxGrade = maxGrade;
        this.isInteger = isInteger;
    }

    public Number gradeConverter(Number grade) {
        double value = grade.doubleValue();

        if (Double.compare(value, minGrade) < 0 ||
                Double.compare(value, maxGrade) > 0) {
            throw new IllegalArgumentException(MessageFormat.format("Value {0} is out of range [{1} - {2}].",
                    grade, minGrade, maxGrade));
        }

        if (isInteger)
            return grade.intValue();

        return value;
    }

    public double getMinGrade() {
        return minGrade;
    }

    public double getMaxGrade() {
        return maxGrade;
    }
}
