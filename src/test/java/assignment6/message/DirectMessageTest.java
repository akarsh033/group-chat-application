package assignment6.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class DirectMessageTest {

  DirectMessage directMessage;
  DirectMessage directMessage1;
  public DirectMessageTest() {
    directMessage = new DirectMessage("Pranay","Akarsh","Do Assignment");
    directMessage1 = new DirectMessage("Pranay","Harshit","It's me");

  }

  @Test
  void displayMessage() {
    System.out.println(directMessage.displayMessage(directMessage.toString()));
    assertEquals(directMessage.displayMessage(directMessage.toString())," (login) Pranay->Akarsh: Do Assignment");
  }

  @Test
  void toBytes() {
    System.out.println(directMessage1.toBytes());
  }

  @Test
  void testToString() {
    System.out.println(directMessage.toString());
  }

  @Test
  void testEquals() {
    assertEquals(directMessage,directMessage);
    assertFalse(directMessage.equals(directMessage1));
    assertFalse(directMessage.equals(null));
  }

  @Test
  void testHashCode() {
    assertEquals(Objects.hashCode(directMessage),directMessage.hashCode());
  }
}