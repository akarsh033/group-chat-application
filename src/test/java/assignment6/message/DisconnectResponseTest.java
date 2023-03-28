package assignment6.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class DisconnectResponseTest {

  DisconnectResponse disconnectResponse;
  DisconnectResponse disconnectResponse1;

  public DisconnectResponseTest() {

    disconnectResponse = new DisconnectResponse("Pranay");
    disconnectResponse1 = new DisconnectResponse("Harshit");
  }

  @Test
  void displayMessage() {
    System.out.println(disconnectResponse.displayMessage(disconnectResponse.toString()));
    assertEquals(disconnectResponse.displayMessage(disconnectResponse.toString())," (ClientHandler) SERVER: signedOff");
  }

  @Test
  void toBytes() {
    System.out.println(disconnectResponse.toBytes());
  }

  @Test
  void testToString() {
    System.out.println(disconnectResponse.toString());
  }

  @Test
  void testEquals() {
    assertTrue(disconnectResponse.equals(disconnectResponse));
    assertFalse(disconnectResponse.equals(null));
    assertFalse(disconnectResponse.equals(disconnectResponse1));
  }

  @Test
  void testHashCode() {
    assertEquals(Objects.hashCode(disconnectResponse),disconnectResponse.hashCode());
  }
}