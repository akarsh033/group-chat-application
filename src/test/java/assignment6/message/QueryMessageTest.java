package assignment6.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class QueryMessageTest {
  QueryMessage queryMessage;
  QueryMessage queryMessage1;

  public QueryMessageTest() {
    queryMessage = new QueryMessage("Pranay");
    queryMessage1 = new QueryMessage("Harshit");
  }

  @Test
  void testEquals() {
    assertEquals(queryMessage,queryMessage);
    assertFalse(queryMessage1.equals(queryMessage));
    assertFalse(queryMessage1.equals(null));


  }

  @Test
  void testHashCode() {
    assertEquals(queryMessage.hashCode(), Objects.hashCode(queryMessage));
  }

  @Test
  void displayMessage() {
    try{
    System.out.println(queryMessage.displayMessage(queryMessage.toString()));
    }
    catch (Exception e){
      System.out.println("Error");

    }
  }

  @Test
  void toBytes() {
    System.out.println(queryMessage.toBytes());
  }

  @Test
  void testToString() {
    System.out.println(queryMessage.toString());
  }
}