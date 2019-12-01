package com.epam.courses.java.fundamentals.threads.practice.task1;

import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class CountsRead extends Thread implements Runnable{
  private FileToRead file;
  private Map<Long, Account> accountList;
  @NonFinal
  private boolean run;
  ReentrantLock lock;

  public CountsRead(@NotNull String name, FileToRead file, Map<Long, Account> accountList) {
    super(name);
    this.file = file;
    this.accountList = accountList;
    this.run = true;
    this.lock = new ReentrantLock();
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

  /**
   * Executed via synchronized (version 1)
   * */
  Transaction readFromFile() throws IOException {
    Transaction transaction = null;
    synchronized (file) {
      if ((file.getFile().length() - file.getCurrentByte()) < 2) {
        run = false;
        return null;
      }
      System.out.println("Thread " + getName() + " is reading file");
      file.getFile().seek(file.getCurrentByte());
      String res = file.getFile().readLine();
      transaction = Transaction.getTransaction(res);
      if (transaction != null) file.setCurrentByte(file.getCurrentByte() + res.length() + 1);
      System.out.println("Thread " + getName() + " changed currentByte to " + file.getCurrentByte());
    }
    return transaction;
  }

  /**
   * Executed via java.util.concurrent (version 2)
   * */
  void addTransaction(Transaction transaction) {
    if (transaction == null) return;
      try {
        lock.lock();
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
      }catch (Exception e){
        e.printStackTrace();
    } finally {
        lock.unlock();
      }
  }
}
