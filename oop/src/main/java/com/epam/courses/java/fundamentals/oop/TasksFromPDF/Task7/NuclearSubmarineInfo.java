package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task7;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface NuclearSubmarineInfo {
    String projectName() default "Borei";

    String name() default "name";

    boolean isNuclear() default true;

    String fleet() default "Severniy";
}
