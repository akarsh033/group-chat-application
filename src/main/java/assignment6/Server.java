package assignment6;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Server.
 */
public class Server {

  /**
   * Integer 0
   */
  public static Integer ZERO=0;
  /**
   * Integer 1
   */
  public static Integer ONE=1;
  /**
   * Integer 2
   */
  public static Integer TWO=2;
  /**
   * Integer 3
   */
  public static Integer THREE=3;
  /**
   * Integer 4
   */
  public static Integer FOUR=4;
  /**
   * Integer 6
   */
  public static Integer SIX=6;

  /**
   * Integer 8
   */
  public static Integer EIGHT=8;

//  public static Integer SERVER_PORT =5000;


  /**
   * The Counter.
   */
  static Integer counter = ZERO;
  /**
   * The Active clients.
   */
  static ConcurrentHashMap<String, ClientHandler> activeClients = new ConcurrentHashMap();

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws Exception the exception
   */
  public static void main(String[] args) throws Exception {
    try {
      ServerSocket server = new ServerSocket();
      Socket socket;

      System.out.println("ClientHandler Started ....");
      System.out.println("listening on port: 5000");
      while (true) {
        counter++;
        socket = server.accept();  //server accept the client connection request
          ClientHandler clientHandlerThread = new ClientHandler(socket, counter,
              socket.getOutputStream(),
              socket.getInputStream()); //send  the request to a separate thread
          clientHandlerThread.start();
      }
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      Server.activeClients.forEach((k, v) -> {
        v.stop();
      });
    }
  }
}
