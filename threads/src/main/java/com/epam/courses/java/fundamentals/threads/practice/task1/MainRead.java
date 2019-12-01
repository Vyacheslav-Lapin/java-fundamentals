package com.epam.courses.java.fundamentals.threads.practice.task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainRead {
  public static void main(String[] args) throws InterruptedException, IOException{
    FileToRead file = FileToRead.getFile(
        "threads/src/main/java/com/epam/courses/java/fundamentals/threads/practice/task1/Transactions.txt");
    Map<Long, Account> accounts = new HashMap<>();
    accounts.put(1111L, new Account(1111, 10000.0));
    accounts.put(2222L, new Account(2222, 10000.0));
    accounts.put(3333L, new Account(3333, 10000.0));
    accounts.put(4444L, new Account(4444, 10000.0));

    file.fillFile(500, new ArrayList<>(accounts.keySet()));

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

    Thread.sleep(500);

    t1.stopThread();
    t2.stopThread();
    t3.stopThread();
    t4.stopThread();
    t5.stopThread();

    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();

    for (long acc : accounts.keySet()){
      System.out.println(acc + ": "+ accounts.get(acc).getValue());
    }
  }
}
