package assignment6.message;
import assignment6.DisplayMessage;
import assignment6.MessageIdentifier;
import assignment6.StringManipulation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;

/**
 * java class for broadcasting message
 */
public class BroadcastMessage implements ByteInterface {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BroadcastMessage that = (BroadcastMessage) o;
    return Objects.equals(userName, that.userName) && Objects.equals(content,
        that.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, content);
  }

  private String userName;
  private String content;


  /**
   * message identifier
   */
  private final static MessageIdentifier identifier = MessageIdentifier.BROADCAST_MESSAGE;

  /**
   *
   * @param userName userName
   * @param content message
   */
  public BroadcastMessage(String userName, String content) {
    this.userName = userName;
    this.content = content;
  }

  /**
   *
   * @param rawInput input
   * @return the processed out
   */
  public static String displayMessage(String rawInput) {
    StringManipulation stringManipulation = new StringManipulation();
    String delimiter = " ";
    String[] tokens = rawInput.split(delimiter);
    String content = stringManipulation.concatenate(tokens, 4);
    String sender= tokens[2];
    DisplayMessage display = new DisplayMessage(identifier.getCommand(), sender, content);
    return display.toString();
  }

  @Override
  public String toString() {
    String delimiter =" ";
    StringBuilder sb = new StringBuilder();
    sb.append(identifier.getValue());
    sb.append(delimiter);
    sb.append(userName.length());
    sb.append(delimiter);
    sb.append(userName);
    sb.append(delimiter);
    sb.append(content.length());
    sb.append(delimiter);
    sb.append(content);
    return sb.toString();
  }

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

}
