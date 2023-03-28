package assignment6.message;
import assignment6.DisplayMessage;
import assignment6.MessageIdentifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;

/**
 * class disconnect response
 */
public class DisconnectResponse implements ByteInterface {



  private static String splitBy = " ";
  private String userName;
  private static String sender = "SERVER";
  private static String content = "signedOff";
  /**
   * identifier
   */
  private static MessageIdentifier identifier = MessageIdentifier.DISCONNECT_RESPONSE;

  /**
   * the constructor
   * @param userName userName
   */
  public DisconnectResponse(String userName) {
    this.userName = userName;
  }

  /**
   * method to display the message
   * @param rawInput in
   * @return the message to be displayed
   */
  public static String displayMessage(String rawInput) {
    DisplayMessage display = new DisplayMessage(identifier.getCommand(), sender, content);
    return display.toString();
  }

  /**
   * method to return bytes converted form
   * @return bytes
   */

  @Override
  public byte[] toBytes() {
    List<Byte> result = new ArrayList<>();
    char space = ' ';
    result.add(Integer.valueOf(identifier.getValue()).byteValue());
    result.add((byte) space);
    result.add((byte) space);
    Byte[] resultingArray = result.toArray(new Byte[0]);
    return ArrayUtils.addAll(ArrayUtils.toPrimitive(resultingArray));
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
    sb.append(content);
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
    DisconnectResponse that = (DisconnectResponse) o;
    return Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName);
  }
}
