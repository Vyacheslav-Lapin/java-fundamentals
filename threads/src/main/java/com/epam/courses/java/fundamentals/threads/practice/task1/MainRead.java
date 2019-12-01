package com.epam.courses.java.fundamentals.threads.practice.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * В текстовом (или xml) файле содержится информация о переводах средств со счета на счет.
 * Создайте приложение, позволяющее в параллельном режиме обработать эту информацию (счета в приложении представляют собой объекты).
 * Синхронизируйте код приложения используя ключевое слово synchronized (1 вариант) и библиотеку java.util.concurrent (2 вариант).
 */

public class MainRead {

  public static void main(String[] args) throws InterruptedException {
    FileToRead file = FileToRead.getFile(
        "threads/src/main/java/com/epam/courses/java/fundamentals/threads/practice/task1/Transactions.txt");
    Map<Long, Account> accounts = new HashMap<>();
    accounts.put(1111L, new Account(1111, 10000.0));
    accounts.put(2222L, new Account(2222, 10000.0));
    accounts.put(3333L, new Account(3333, 10000.0));
    accounts.put(4444L, new Account(4444, 10000.0));

    Objects.requireNonNull(file).fillFile(500, new ArrayList<>(accounts.keySet()));

    executeVersion1(file, accounts);

    //executeVersion2(file, accounts);
  }

  static void executeVersion1(FileToRead file, Map<Long, Account> accounts) {
    ExecutorService service = Executors.newFixedThreadPool(5);
    service.execute(new CountsRead("1", file, accounts));
    service.execute(new CountsRead("2", file, accounts));
    service.execute(new CountsRead("3", file, accounts));
    service.execute(new CountsRead("4", file, accounts));
    service.execute(new CountsRead("5", file, accounts));
    service.execute(() -> {
      for (long acc : accounts.keySet()) {
        System.out.println(acc + ": " + accounts.get(acc).getValue());
      }
    });
    service.shutdown();
  }

  static void executeVersion2(FileToRead file, Map<Long, Account> accounts) throws InterruptedException {
    CountsRead t1 = new CountsRead("1", file, accounts);
    CountsRead t2 = new CountsRead("2", file, accounts);
    CountsRead t3 = new CountsRead("3", file, accounts);
    CountsRead t4 = new CountsRead("4", file, accounts);
    CountsRead t5 = new CountsRead("5", file, accounts);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();

    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();

    for (long acc : accounts.keySet()) {
      System.out.println(acc + ": " + accounts.get(acc).getValue());
    }

  }
}
