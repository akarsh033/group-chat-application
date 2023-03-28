package assignment6.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class ConnectResponseTest {


  ConnectResponse connectResponse;
  ConnectResponse connectResponse1;

  public ConnectResponseTest() {
  connectResponse = new ConnectResponse(true,"checkingMessage");
  connectResponse1 = new ConnectResponse(false,"checkingMessage1");
  }

  @Test
  void displayMessage() {
    System.out.println(connectResponse.displayMessage(connectResponse.toString()));
    assertEquals(connectResponse.displayMessage(connectResponse.toString())," (ClientHandler) SERVER: checkingMessage");
  }

  @Test
  void toBytes() {
    System.out.println(connectResponse.toBytes());
  }

  @Test
  void testToString() {
    System.out.println(connectResponse.toString());
  }

  @Test
  void equalsTest() {
    assertTrue(connectResponse.equals(connectResponse));
    assertFalse(connectResponse.equals(connectResponse1));
    assertFalse(connectResponse1.equals(null));
  }

  @Test
  void hashcodeTest(){
    assertEquals(connectResponse.hashCode(), Objects.hashCode(connectResponse));

  }
}