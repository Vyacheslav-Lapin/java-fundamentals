package practice.Task1;

import java.text.SimpleDateFormat;

import java.util.Date;

public class CrazyLogger {
  private StringBuilder myLogger = new StringBuilder();
  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm");

  public void addLog(String info) {
    myLogger.append(getDateFormat()).append(" - ").append(info).append("\n");
  }

  public String getDateFormat() {
    return dateFormat.format(new Date());
  }

  public String getLogs() {
    return myLogger.toString();
  }

  public String getLog(String info) {
    String[] logNotes = myLogger.toString().split("\n");
    for (String s : logNotes) {
      if (s.contains(info))
        return s;
    }
    return null;
  }

}
