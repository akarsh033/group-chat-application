package assignment6.message;
import assignment6.DisplayMessage;
import assignment6.MessageIdentifier;
import assignment6.StringManipulation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;

/**
 * class for direct message
 */
public class DirectMessage implements ByteInterface {



  private String userName;
  private String receiverN;
  private String content;

  private static String splitBy = " ";
  /**
   * identifier
   */
  private final static MessageIdentifier identifier=MessageIdentifier.CONNECT_MESSAGE;

  /**
   * direct message
   * @param userName userName
   * @param receiverName receiverName
   * @param content message
   */
  public DirectMessage(String userName, String receiverName, String content) {
    this.userName = userName;
    this.receiverN = receiverName;
    this.content = content;
  }

  /**
   *
   * @param rawInput in
   * @return message to be displayed
   */
  public static String displayMessage(String rawInput) {
    String[] tokens = rawInput.split(splitBy);
    String content = new StringManipulation().concatenate(tokens, 6);
    String receiver= tokens[4];
    String sender= tokens[2];
    DisplayMessage display = new DisplayMessage(identifier.getCommand(), sender+"->"+receiver, content);
    return display.toString();
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
    Byte[] resultArray = result.toArray(new Byte[0]);
    return ArrayUtils.addAll(ArrayUtils.toPrimitive(resultArray), userName.getBytes());
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
    sb.append(splitBy);
    sb.append(content.length());
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
    DirectMessage that = (DirectMessage) o;
    return Objects.equals(userName, that.userName) && Objects.equals(receiverN,
        that.receiverN);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, receiverN);
  }
}
