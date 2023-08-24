package pro.vlapin.courses.java.fundamentals.io;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class NetUtil {

  @SneakyThrows
  public String getIp() {
    if (System.getProperty("os.name").startsWith("Mac")) {
      @Cleanup val socket = new Socket();
      socket.connect(new InetSocketAddress("google.com", 80));
      return socket.getLocalAddress().getHostAddress();
    }
    try (val socket = new DatagramSocket()) {
      socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
      return socket.getLocalAddress().getHostAddress();
    }
  }
}
