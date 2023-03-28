//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import assignment6.DisplayMessage;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

public class DisplayMessageTest {
  DisplayMessage dis=new DisplayMessage("test","test","test");
  DisplayMessage dis2=new DisplayMessage("test","test","test");
  @Test
  public void testToString() {
    assertEquals(" (test) test: test",dis.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(dis,dis2);
  }

  @Test
  public void testHashCode() {
    assertEquals(dis.hashCode(),dis2.hashCode());
  }
}
