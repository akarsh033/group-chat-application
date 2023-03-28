package assignment6.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class FailedMessageTest {

  FailedMessage failedMessage;
  FailedMessage failedMessage1;


  public FailedMessageTest() {
    failedMessage = new FailedMessage("Pranay",":(");
    failedMessage1 = new FailedMessage("Harshit",":");
  }

  @Test
  void displayMessage() {
    System.out.println(failedMessage.displayMessage(failedMessage.toString()));
    assertEquals(failedMessage.displayMessage(failedMessage.toString())," (ClientHandler) Pranay: :(");
  }

  @Test
  void toBytes() {
    System.out.println(failedMessage.toBytes());
  }

  @Test
  void testToString() {
    System.out.println(failedMessage.toString());
  }

  @Test
  void testEquals() {
    assertEquals(failedMessage,failedMessage);
    assertFalse(failedMessage.equals(failedMessage1));
    assertFalse(failedMessage.equals(null));
  }

  @Test
  void testHashCode() {
    assertEquals(failedMessage.hashCode(), Objects.hashCode(failedMessage));
  }
}