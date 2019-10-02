package com.epam.courses.java.fundamentals.oop.demo;

public class WithAnotherClass {

    public static void main(String[] args) {
        var object = new AboutJava();
        object.printReleaseData();
    }
}

class AboutJava {
    void printReleaseData(){
        System.out.println("Java уже здесь!!!");
    }
}
