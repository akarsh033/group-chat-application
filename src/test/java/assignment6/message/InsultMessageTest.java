package assignment6.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class InsultMessageTest {

  InsultMessage insultMessage;
  InsultMessage insultMessage1;

  public InsultMessageTest() {
    insultMessage = new InsultMessage("Pranay","Harshit");
    insultMessage1 = new InsultMessage("Harshit","Lucky");
  }

  @Test
  void toBytes() {
    System.out.println(insultMessage.toBytes());
  }

  @Test
  void testToString() {
    System.out.println(insultMessage.toString());
  }

  @Test
  void testEquals() {
    assertEquals(insultMessage,insultMessage);
    assertFalse(insultMessage.equals(insultMessage1));
    assertFalse(insultMessage.equals(null));
  }

  @Test
  void testHashCode() {
    assertEquals(insultMessage.hashCode(),Objects.hashCode(insultMessage));
  }
}