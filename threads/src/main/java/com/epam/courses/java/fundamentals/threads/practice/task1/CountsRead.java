package com.epam.courses.java.fundamentals.threads.practice.task1;

import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

/**
 * В текстовом (или xml) файле содержится информация о переводах средств со счета на счет.
 * Создайте приложение, позволяющее в параллельном режиме обработать эту информацию (счета в приложении представляют собой объекты).
 * Синхронизируйте код приложения используя ключевое слово synchronized (1 вариант) и библиотеку java.util.concurrent (2 вариант).
 */

public class CountsRead extends Thread {
  private FileToRead file;
  private Map<Long, Account> accountList;
  @NonFinal
  private boolean run;

  public CountsRead(@NotNull String name, FileToRead file, Map<Long, Account> accountList) {
    super(name);
    this.file = file;
    this.accountList = accountList;
    this.run = true;
  }

  public void stopThread() {
    run = false;
  }

  public void run() {
    try {
      while (run) {
        Transaction tr = readFromFile();
        addTransaction(tr);
      }
      System.out.println("Поток " + getName() + " завершил работу.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  Transaction readFromFile() throws IOException {
    Transaction transaction = null;
    synchronized (file) {
      System.out.println("Thread " + getName() + " is reading file");
      file.getFile().seek(file.getCurrentByte());
      String res = file.getFile().readLine();
      transaction = Transaction.getTransaction(res);
      if (transaction != null) file.setCurrentByte(file.getCurrentByte() + res.length() + 1);
      System.out.println("Thread " + getName() + " changed currentByte to " + file.getCurrentByte());
    }
    return transaction;
  }

  void addTransaction(Transaction transaction) {
    if (transaction == null) return;
    synchronized (accountList) {
      Account sender = accountList.get(transaction.getSenderNum());
      Account receiver = accountList.get(transaction.getReceiverNum());
      if (sender.getValue() < transaction.getAmount() || transaction.getAmount() <= 0) return;
      sender.addToLog("Value at start: " + sender.getValue() + ", ");
      receiver.addToLog("Value at start: " + receiver.getValue() + ", ");

      sender.setValue(sender.getValue() - transaction.getAmount());
      receiver.setValue(receiver.getValue() + transaction.getAmount());
      System.out.println("Thread " + getName() + " changed sender " + sender.getAccNumber() + " to " + sender.getValue() +
          " and receiver " + receiver.getAccNumber() + " to " + receiver.getValue());
      sender.addToLog(transaction.toString() + ", value at end: " + sender.getValue() + "\n");
      receiver.addToLog(transaction.toString() + ", value at end: " + receiver.getValue() + "\n");
    }
  }

}
