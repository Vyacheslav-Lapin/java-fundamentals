package com.epam.courses.java.fundamentals.threads.practice.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class Transaction {
  /**
   * Transaction template: "21.08.2019 14:28:36 +0300 From 88889999 to 11112222 256.08"
   */
  ZonedDateTime time;
  long senderNum;
  long receiverNum;
  double amount;
  static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss Z");

  static Transaction getTransaction(String str) {
    try{
      String[] values = str.split(" ");
      String date = values[0]  + " " + values[1] + " " + values[2];
      return new Transaction(ZonedDateTime.parse(date, format), Long.parseLong(values[4]),
          Long.parseLong(values[6]), Double.parseDouble(values[7]));
    }catch (Exception e){
      e.printStackTrace();
    }
    return null;
  }

  static String asString(long sender, long receiver, double amount){
    ZonedDateTime dateTime = ZonedDateTime.now();
    return dateTime.format(format)+" From "+sender+" to "+receiver+" "+amount+"\n";
  }

  @Override
  public String toString() {
    return time.format(format)+" From "+senderNum+" to "+receiverNum+" "+amount+"\n";
  }
}
