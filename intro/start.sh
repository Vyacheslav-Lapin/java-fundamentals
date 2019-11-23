#!/bin/sh
mkdir -p target/classes

javac --release 13 --enable-preview -classpath ./target/classes -d ./target/classes/com/epam/courses/java/fundamentals/intro/practice/task1 src/main/java/com/epam/courses/java/fundamentals/intro/practice/task1/Main.java

java --enable-preview -classpath ./target/classes com.epam.courses.java.fundamentals.intro.practice.task1.Main 

