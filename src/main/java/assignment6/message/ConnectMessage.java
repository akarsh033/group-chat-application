package assignment6.message;

import assignment6.MessageIdentifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;

/**
 * java class for connect message
 */
public class ConnectMessage implements ByteInterface {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectMessage that = (ConnectMessage) o;
    return Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName);
  }

  private String userName;
  /**
   * identifier
   */
  private final static MessageIdentifier identifier=MessageIdentifier.CONNECT_MESSAGE;

  /**
   *  the constructor
   * @param userName userName
   */
  public ConnectMessage(String userName) {
    this.userName = userName;
  }

  /**
   * method to convert to bytes
   * @return bytes converted out
   */

  @Override
  public byte[] toBytes() {
    List<Byte> res=new ArrayList<>();
    char space=' ';
    Integer length=userName.getBytes().length;
    res.add(Integer.valueOf(identifier.getValue()).byteValue());
    res.add((byte)space);
    res.add(length.byteValue());
    res.add((byte)space);
    Byte[]resArr=res.toArray(new Byte[0]);
    return ArrayUtils.addAll(ArrayUtils.toPrimitive(resArr),userName.getBytes());
  }



  @Override
  public String toString() {
    String delimiter = " ";
    StringBuilder sb=new StringBuilder();
    sb.append(identifier.getValue());
    sb.append(delimiter);
    sb.append(userName.length());
    sb.append(delimiter);
    sb.append(userName);
    return sb.toString();
  }


}
