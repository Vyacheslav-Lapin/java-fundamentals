package pro.vlapin.courses.java.fundamentals.oop.demo;

public class CommandArgUsage {
    public static void main(String... args) {
        for (var s : args)
            System.out.println("Следующий аргумент = " + s);
    }
}
