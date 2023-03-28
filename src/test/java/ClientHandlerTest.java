import assignment6.ChatRoomFullException;
import assignment6.Client;
import assignment6.ClientHandler;
import assignment6.message.ConnectResponse;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientHandlerTest {

  @BeforeEach
  public void setUp() throws Exception {
  }

  @Test
  public void processReadTest() throws IOException {
    ServerSocket server = new ServerSocket(5008);
    try {
      Client client = new Client("127.0.0.1", 5008, "shukla");
      Socket socket = server.accept();
      ClientHandler clientHandlerThread = new ClientHandler(socket, 1,
          socket.getOutputStream(),
          socket.getInputStream());
      String test = "21 5 shukla";
      int count = clientHandlerThread.getSocket().getInputStream().available();
      //Skip in case previous bytes
      if (clientHandlerThread.getSocket().getInputStream().available() > 0) {
        clientHandlerThread.getSocket().getInputStream().skip(count);
      }
      client.getOutputStream().write(test.getBytes());
      clientHandlerThread.processRead();
      Assertions.assertNotNull(client.getInputStream());
      Assertions.assertNotNull(clientHandlerThread.getSocket().getInputStream());
      server.close();
    } catch (BindException e) {
      server.close();
      System.exit(1);
    }
  }

  @Test
  public void processWriteTest() throws IOException {
    ServerSocket server = null;
    try {
      server = new ServerSocket(5004);
    } catch (Exception e) {
      e.printStackTrace();
    }

    Client client = new Client("127.0.0.1", 5004, "shukla");
    Socket socket = server.accept();
    ClientHandler clientHandlerThread = new ClientHandler(socket, 1,
        socket.getOutputStream(),
        socket.getInputStream());
    ConnectResponse connectResponse = new ConnectResponse(true, "Testing");
    clientHandlerThread.processWrite(clientHandlerThread, connectResponse.toString());
    Assertions.assertNotNull(clientHandlerThread.getSocket().getOutputStream());
    socket.close();
    server.close();
  }

  @Test//(expected = ChatRoomFullException.class)
  public void testChatRoomFull() throws IOException, ChatRoomFullException {
    ServerSocket server = new ServerSocket(5002);
    Client client1 = new Client("127.0.0.1", 5002, "shukla");
    Client client2 = new Client("127.0.0.1", 5002, "a10");
    Client client3 = new Client("127.0.0.1", 5002, "a1");
    Client client4 = new Client("127.0.0.1", 5002, "a2");
    Client client5 = new Client("127.0.0.1", 5002, "a3");
    Client client6 = new Client("127.0.0.1", 5002, "a4");
    Client client7 = new Client("127.0.0.1", 5002, "a5");
    Client client8 = new Client("127.0.0.1", 5002, "a6");
    Client client9 = new Client("127.0.0.1", 5002, "a7");
    Client client10 = new Client("127.0.0.1", 5002, "a8");
    Client client11 = new Client("127.0.0.1", 5002, "a9");

    Socket socket = server.accept();

    ClientHandler clientHandlerThread = new ClientHandler(socket, 0,
        socket.getOutputStream(),
        socket.getInputStream());

    ClientHandler clientHandlerThread1 = new ClientHandler(socket, 1,
        socket.getOutputStream(),
        socket.getInputStream());
    ClientHandler clientHandlerThread2 = new ClientHandler(socket, 2,
        socket.getOutputStream(),
        socket.getInputStream());
    ClientHandler clientHandlerThread3 = new ClientHandler(socket, 3,
        socket.getOutputStream(),
        socket.getInputStream());
    ClientHandler clientHandlerThread4 = new ClientHandler(socket, 4,
        socket.getOutputStream(),
        socket.getInputStream());
    ClientHandler clientHandlerThread5 = new ClientHandler(socket, 5,
        socket.getOutputStream(),
        socket.getInputStream());
    ClientHandler clientHandlerThread6 = new ClientHandler(socket, 6,
        socket.getOutputStream(),
        socket.getInputStream());
    ClientHandler clientHandlerThread7 = new ClientHandler(socket, 7,
        socket.getOutputStream(),
        socket.getInputStream());
    ClientHandler clientHandlerThread8 = new ClientHandler(socket, 8,
        socket.getOutputStream(),
        socket.getInputStream());
    ClientHandler clientHandlerThread9 = new ClientHandler(socket, 9,
        socket.getOutputStream(),
        socket.getInputStream());
    ClientHandler clientHandlerThread10 = new ClientHandler(socket, 10,
        socket.getOutputStream(),
        socket.getInputStream());
    clientHandlerThread.processConnectMessage(new String[]{"19", "5", "shukla"});
    clientHandlerThread1.processConnectMessage(new String[]{"19", "3", "a1"});
    clientHandlerThread2.processConnectMessage(new String[]{"19", "3", "a2"});
    clientHandlerThread3.processConnectMessage(new String[]{"19", "3", "a3"});
    clientHandlerThread4.processConnectMessage(new String[]{"19", "2", "a4"});
    clientHandlerThread5.processConnectMessage(new String[]{"19", "3", "a5"});
    clientHandlerThread6.processConnectMessage(new String[]{"19", "3", "a6"});
    clientHandlerThread7.processConnectMessage(new String[]{"19", "4", "a7"});
    clientHandlerThread8.processConnectMessage(new String[]{"19", "3", "a8"});
    clientHandlerThread9.processConnectMessage(new String[]{"19", "3", "a9"});
    //Testing Equals and Hashcode
    Assertions.assertEquals(clientHandlerThread, clientHandlerThread);
    Assertions.assertNotEquals(clientHandlerThread, clientHandlerThread1);
    Assertions.assertTrue(clientHandlerThread.isKeepRunning());
//    Assertions.assertNotEquals(clientHandlerThread, clientHandlerThread1);
    Assertions.assertEquals(clientHandlerThread.hashCode(), clientHandlerThread.hashCode());

//    clientHandlerThread10.processConnectMessage(new String[]{"19", "3", "a10"});
    socket.close();
    server.close();
  }


}
