package assignment6.message;

import assignment6.MessageIdentifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;

/**
 * disconnect message class
 */
public class DisconnectMessage implements ByteInterface{





  private static String splitBy = " ";


  private String userName;
  /**
   * identifier
   */
  private static MessageIdentifier identifier=MessageIdentifier.DISCONNECT_MESSAGE;

  /**
   * the constructor
   * @param userName userName
   */
  public DisconnectMessage(String userName) {
    this.userName = userName;
  }

  /**
   * method to convert to bytes
   * @return bytes
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
    Byte[]resArr=result.toArray(new Byte[0]);
    return ArrayUtils.addAll(ArrayUtils.toPrimitive(resArr),userName.getBytes());
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DisconnectMessage that = (DisconnectMessage) o;
    return Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName);
  }
}
