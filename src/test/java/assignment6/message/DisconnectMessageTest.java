package assignment6.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class DisconnectMessageTest {

  DisconnectMessage disconnectMessage;
  DisconnectMessage disconnectMessage1;


  public DisconnectMessageTest() {
    disconnectMessage = new DisconnectMessage("Pranay");
    disconnectMessage1 = new DisconnectMessage("Harshit");
  }

  @Test
  void toBytes() {
    System.out.println(disconnectMessage.toBytes());
  }

  @Test
  void testToString() {
    System.out.println(disconnectMessage.toString());
  }

  @Test
  void testEquals() {
    assertEquals(disconnectMessage,disconnectMessage);
    assertFalse(disconnectMessage.equals(null));
    assertFalse(disconnectMessage.equals(disconnectMessage1));
  }

  @Test
  void testHashCode() {
    assertEquals(disconnectMessage.hashCode(), Objects.hashCode(disconnectMessage));
  }
}