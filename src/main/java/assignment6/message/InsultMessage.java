package assignment6.message;

import assignment6.MessageIdentifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;

/**
 * class for insult message
 */
public class InsultMessage implements ByteInterface {



  private static String splitBy = " ";

  private String userName;
  private String receiverN;


  /**
   * identifier
   */
  private static MessageIdentifier identifier = MessageIdentifier.SEND_INSULT;


  /**
   * the constructor
   * @param userName userName
   * @param receiverName receiverName
   */
  public InsultMessage(String userName, String receiverName) {
    this.userName = userName;
    this.receiverN = receiverName;
  }

  /**
   * method to convert to bytes
   * @return bytes converted output
   */

  @Override
  public byte[] toBytes() {
    List<Byte> result = new ArrayList<>();
    char space = ' ';
    Integer length = userName.getBytes().length;
    result.add(Integer.valueOf(identifier.getValue()).byteValue());
    result.add((byte) space);
    result.add(length.byteValue());
    result.add((byte) space);
    Byte[] resArr = result.toArray(new Byte[0]);
    return ArrayUtils.addAll(ArrayUtils.toPrimitive(resArr), userName.getBytes());
  }



  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(identifier.getValue());
    sb.append(splitBy);
    sb.append(userName.length());
    sb.append(splitBy);
    sb.append(userName);
    sb.append(splitBy);
    sb.append(receiverN.length());
    sb.append(splitBy);
    sb.append(receiverN);
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsultMessage that = (InsultMessage) o;
    return Objects.equals(userName, that.userName) && Objects.equals(receiverN,
        that.receiverN);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, receiverN);
  }
}
