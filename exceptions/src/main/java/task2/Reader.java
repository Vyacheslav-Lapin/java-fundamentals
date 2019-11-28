package task2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Reader {

  private static Map<Object, Object> map = new HashMap<>();
  private static final String PATH = "collections/src/main/resources/test.properties";

  public static void main(String[] args) {
    Reader reader = new Reader();
    reader.readFromPropertiesFile(PATH);
  }

  private void readFromPropertiesFile(String filePath) {
    try(InputStream input = new FileInputStream(filePath)) {
      Properties properties = new Properties();
      properties.load(input);
      properties.forEach((k, v) -> map.put(k,v));
      System.out.println(map.keySet() + " " + map.values());
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
