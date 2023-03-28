package assignment6.message;
import assignment6.DisplayMessage;
import assignment6.MessageIdentifier;
import assignment6.StringManipulation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;


/**
 * java class for failed message
 */
public class FailedMessage implements ByteInterface {



  private static String splitBy = " ";

  private String userName;

  /**
   * index
   */
  public static int index1 = 4;

  /**
   * index
   */

  public static int index2 = 2;
  private String content;
  /**
   * message identifier
   */
  private static MessageIdentifier identifier = MessageIdentifier.FAILED_MESSAGE;

  /**
   * the constructor
   * @param userName userName
   * @param content message
   */
  public FailedMessage(String userName, String content) {
    this.userName = userName;
    this.content = content;
  }

  /**
   * method for displaying the message
   * @param rawInput input
   * @return message
   */
  public static String displayMessage(String rawInput) {
    String[] tokens = rawInput.split(splitBy);

    String content = new StringManipulation().concatenate(tokens, index1);
    String sender= tokens[index2];
    DisplayMessage display = new DisplayMessage(identifier.getCommand(), sender, content);
    return display.toString();
  }

  /**
   * method to convert to bytes format
   * @return bytes converted out
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
    Byte[] resultingArray = result.toArray(new Byte[0]);
    return ArrayUtils.addAll(ArrayUtils.toPrimitive(resultingArray), userName.getBytes());
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
    FailedMessage that = (FailedMessage) o;
    return Objects.equals(userName, that.userName) && Objects.equals(content,
        that.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, content);
  }
}
