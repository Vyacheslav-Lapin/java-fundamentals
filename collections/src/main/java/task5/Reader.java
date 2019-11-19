package task5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Reader {

  private static Map<Object, Object> map = new HashMap<Object, Object>();
  private static final String PATH = "collections/src/main/resources/test.properties";

  public static void main(String[] args) throws IOException {
    Reader reader = new Reader();
    reader.readFromPropertiesFile(PATH);
    }

  private void readFromPropertiesFile(String filePath) throws IOException {
    try(InputStream input = new FileInputStream(filePath)) {
      Properties properties = new Properties();
      properties.load(input);
      properties.forEach((k, v) -> map.put(k,v));
      System.out.println(map.keySet() + " " + map.values());
    }
    }
}
