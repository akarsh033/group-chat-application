package assignment6;
import static assignment6.Server.ZERO;

import java.util.*;

/**
 * sentenceGenerator
 *
 */
public class SentenceGenerator {


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SentenceGenerator that = (SentenceGenerator) o;
    return Objects.equals(length, that.length);
  }

  @Override
  public int hashCode() {
    return Objects.hash(length);
  }

  private Integer length;

  /**
   * constructor
   * @param length length
   */
  public SentenceGenerator(Integer length) {
    this.length = length;
  }

  /**
   * sentenceGeneratorFunc
   * @return sentence generated
   */
  public String generateSentence(){
    String[] stringArray = {"You look bad today","You are not cool","You are not awesome","You are not generous","You are not kind","How are you so unmaintained", "You are sort of a fool", "You are a clown"};
    Random randI = new Random();
    int myRandInt = randI.nextInt(ZERO,stringArray.length);
    return stringArray[myRandInt];
  }

}
