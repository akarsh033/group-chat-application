package assignment6;

import static assignment6.Server.ONE;

import java.util.Objects;

/**
 * java class to get the required output from the string like concatenation
 */
public class StringManipulation {


  /**
   * Index used
   */
  public static Integer INDEX = 4;


  /**
   * concatenate
   * @param strArr string array
   * @param index index pos
   * @return concatenated st
   */
  public String concatenate(String[] strArr, int index) {
    String result = "";
    for (int i = index; i < strArr.length; i++) {
      if (i != strArr.length - ONE) {

        result = result + strArr[i] + " ";
      } else {
        result = result + strArr[i];
      }
    }
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StringManipulation that = (StringManipulation) o;
    return Objects.equals(INDEX ,that.INDEX);
  }

  @Override
  public int hashCode() {
    return Objects.hash(INDEX);
  }
}



