package assignment6.message;

import assignment6.MessageIdentifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;

/**
 * class for query message
 */
public class QueryMessage implements ByteInterface  {


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryMessage that = (QueryMessage) o;
    return Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName);
  }

  private static String splitBy = " ";

  private static MessageIdentifier identifier=MessageIdentifier.QUERY_CONNECTED_USERS;


  private String userName;

  /**
   * constructor
   * @param userName  userName
   */
  public QueryMessage(String userName) {
    this.userName = userName;
  }

  /**
   * method to display the message
   * @param raw input
   * @return the message
   */
  public static String displayMessage(String raw) {
    /**
     * throw exception at this place
     */
    throw new IllegalStateException("not to be displayed");
  }

  /**
   * method to covert to bytes
   * @return bytes converted out
   */



  @Override
  public byte[] toBytes() {
    List<Byte> result=new ArrayList<>();
    char space=' ';
    Integer length=userName.getBytes().length;
    result.add(Integer.valueOf(identifier.getValue()).byteValue());
    result.add((byte)space);
    result.add(length.byteValue());
    result.add((byte)space);
    Byte[]resultingArray=result.toArray(new Byte[0]);
    return ArrayUtils.addAll(ArrayUtils.toPrimitive(resultingArray),userName.getBytes());
  }




  @Override
  public String toString() {
    StringBuilder sb=new StringBuilder();
    sb.append(identifier.getValue());
    sb.append(splitBy);
    sb.append(userName.length());
    sb.append(splitBy);
    sb.append(userName);
    return sb.toString();
  }

}
