package assignment6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class SentenceGeneratorTest {

  SentenceGenerator sentenceGenerator;
  SentenceGenerator sentenceGenerator1;

  public SentenceGeneratorTest() {
    sentenceGenerator = new SentenceGenerator(8);
    sentenceGenerator1 = new SentenceGenerator(9);
  }

  @Test
  void testEquals() {
    assertTrue(sentenceGenerator.equals(sentenceGenerator));
    assertFalse(sentenceGenerator.equals(null));
    assertFalse(sentenceGenerator.equals(sentenceGenerator1));
  }

  @Test
  void testHashCode() {
    assertEquals(sentenceGenerator1.hashCode(), Objects.hashCode(sentenceGenerator1));
  }

  @Test
  void generateSentence() {
    System.out.println(sentenceGenerator.generateSentence());
  }
}