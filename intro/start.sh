#!/bin/sh
mkdir -p target/classes
javac -classpath src/main/java:. -d target/classes src/main/java/com/epam/courses/java/fundamentals/intro/practice/task1/Main.java
java -classpath target/classes com.epam.courses.java.fundamentals.intro.practice.task1.Main
