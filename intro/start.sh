#!/bin/sh
mkdir -p target/classes
javac -d target/classes/intro src/main/java/com/epam/courses/java/fundamentals/intro/practice/task1/Logic.java src/main/java/com/epam/courses/java/fundamentals/intro/practice/task1/Main.java 
java -cp target/classes/intro com.epam.courses.java.fundamentals.intro.practice.task1.Main

