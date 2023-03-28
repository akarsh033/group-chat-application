package assignment6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class StringManipulationTest {

  StringManipulation stringManipulation;

  public StringManipulationTest() {
   stringManipulation = new StringManipulation();
  }

  @Test
  void concatenate() {
    String [] array = {"Hy","My", "Name", "is", "Pranay", "Shukla","I study in NEU"};
    System.out.println(stringManipulation.concatenate(array,4));
  }

  @Test
  void testEquals() {
    assertEquals(stringManipulation,stringManipulation);
    assertFalse(stringManipulation.equals(null));

  }

  @Test
  void testHashCode() {
    assertEquals(Objects.hashCode(stringManipulation),stringManipulation.hashCode());
  }
}