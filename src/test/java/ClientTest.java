import assignment6.Client;
import assignment6.ClientHandler;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ClientTest {

  @BeforeEach
  public void setUp() throws Exception {

  }

  @Test//(timeout = 5000)
  public void createReadThread() throws IOException {
    ServerSocket server = new ServerSocket(5002);
    try {
      Client client = new Client("127.0.0.1", 5002, "shukla");
      Socket socket = server.accept();
      ClientHandler clientHandlerThread = new ClientHandler(socket, 1,
          socket.getOutputStream(),
          socket.getInputStream());
      clientHandlerThread.getSocket().getOutputStream().write("21 shukla 5".getBytes());
      client.createReadThread();
      Assertions.assertNotNull(client.getInputStream());
      int countBytes = client.getInputStream().available();
      Assertions.assertTrue(countBytes > 0);
      socket.close();
      server.close();
    }catch (BindException e){
      server.close();
      System.exit(0);
    }
  }

  @Test
  public void createWriteThread() throws IOException {
    ServerSocket server = new ServerSocket(5001);
    Client client = new Client("127.0.0.1", 5001, "shukla");
    Socket socket = server.accept();
    ClientHandler clientHandlerThread = new ClientHandler(socket, 1,
        socket.getOutputStream(),
        socket.getInputStream());
    client.getOutputStream().write("protocolString".getBytes(StandardCharsets.UTF_8));
    client.createWriteThread();
    Assertions.assertNotNull(client.getOutputStream());
    Assertions.assertTrue(clientHandlerThread.getSocket().getInputStream().available() > 0);
    Assertions.assertEquals(client,client);
    Assertions.assertEquals(client.hashCode(),client.hashCode());
    socket.close();
    server.close();
  }

  @Test
  public void testEquals() throws IOException {
    ServerSocket server = new ServerSocket(5001);
    Client client = new Client("127.0.0.1", 5001, "shukla");
    Client client2 = new Client("127.0.0.1", 5001, "shukla");
    Assertions.assertNotEquals(client,client2);
  }

}
