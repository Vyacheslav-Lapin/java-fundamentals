#!/bin/sh
mkdir -p target/classes
javac src/main/java/com/epam/courses/java/fundamentals/intro/practice/task1/*.java -d target/classes/
java -cp target/classes/  com.epam.courses.java.fundamentals.intro.practice.task1.Main

