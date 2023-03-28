package assignment6.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class BroadcastMessageTest {
  BroadcastMessage broadcastMessage;
  BroadcastMessage broadcastMessage1;
  public BroadcastMessageTest() {
    broadcastMessage = new BroadcastMessage("random","randomContent");
    broadcastMessage1 = new BroadcastMessage("rand","rc");
  }



  @Test
  void displayContent() {
    System.out.println(broadcastMessage.displayMessage("24 6 Pranay 14 Whatsup how are you doing"));
    assertEquals(broadcastMessage.displayMessage("24 6 Pranay 7 Whatsup")," (@all) Pranay: Whatsup");
  }

  @Test
  public void testToString() {
    assertEquals("24 6 random 13 randomContent",broadcastMessage.toString());

  }

  @Test
  void hashcodeTest(){
    assertEquals(broadcastMessage.hashCode(), Objects.hashCode(broadcastMessage));
  }

  @Test
  void testEqual(){
    assertEquals(broadcastMessage,broadcastMessage);
    assertFalse(broadcastMessage.equals(broadcastMessage1));
    assertFalse(broadcastMessage.equals(null));
  }



  @Test
  void byteTest(){
    System.out.println(broadcastMessage.toBytes());
  }




}