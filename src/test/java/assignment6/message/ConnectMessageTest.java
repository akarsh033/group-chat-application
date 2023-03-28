package assignment6.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class ConnectMessageTest {


  ConnectMessage connectMessage;
  ConnectMessage connectMessage1;
  public ConnectMessageTest() {
    connectMessage = new ConnectMessage("Pranay");
    connectMessage1 = new ConnectMessage("Harsh");

  }

  @Test
  public void toBytes() {
    assertNotNull(connectMessage.toBytes());
  }

  @Test
  public void testToString() {
    System.out.println(connectMessage.toString());
    assertEquals("19 6 Pranay", connectMessage.toString());
  }

  @Test
  void testHashcode(){
    assertEquals(connectMessage.hashCode(), Objects.hashCode(connectMessage));
  }

  @Test
  void equalTest(){
    assertEquals(connectMessage,connectMessage);
    assertFalse(connectMessage.equals(null));
    assertFalse(connectMessage.equals(connectMessage1));
  }


}