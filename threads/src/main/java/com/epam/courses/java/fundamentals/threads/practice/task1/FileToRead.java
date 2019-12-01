package com.epam.courses.java.fundamentals.threads.practice.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.NonFinal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class FileToRead {
  @NonFinal
  RandomAccessFile file;
  @NonFinal
  long currentByte;

  public void setCurrentByte(long currentByte) {this.currentByte = currentByte;}

  public static FileToRead getFile(String fileName) {
    try {
      return new FileToRead(new RandomAccessFile(fileName, "rw"), 0L);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  void writeToFile(String transfer){
    try {
      file.seek(file.length());
      file.writeBytes(transfer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void fillFile(int repeat, List<Long> accs){
    Random random = new Random();
    Map<Long, Long> circle = new HashMap<>();
    for(int i =1; i<accs.size(); i++){
      circle.put(accs.get(i-1), accs.get(i));
    }
    circle.put(accs.get(accs.size()-1), accs.get(0));
    for(int i =0; i<repeat; i++){
      for (long accNum : accs) {
        writeToFile(Transaction.asString(accNum, circle.get(accNum), random.nextInt(1000)));
      }
    }
  }

}
