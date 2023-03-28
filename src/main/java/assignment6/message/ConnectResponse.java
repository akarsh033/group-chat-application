package assignment6.message;
import assignment6.DisplayMessage;
import assignment6.MessageIdentifier;
import assignment6.StringManipulation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;

/**
 * connect response
 */
public class ConnectResponse implements ByteInterface {



  private static String splitBy = " ";
  /**
   * identifier
   */
  private static MessageIdentifier identifier = MessageIdentifier.CONNECT_RESPONSE;

  private static String sender = "SERVER";

  private boolean success;

  private String message;

  /**
   * constructor
   * @param success success
   * @param message message
   */
  public ConnectResponse(boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  /**
   * method to display
   * @param rawInput in
   * @return the message to be displayed
   */
  public static String displayMessage(String rawInput) {
    StringManipulation stringManipulation = new StringManipulation();

    String[] tokens = rawInput.split(splitBy);
    String content = stringManipulation.concatenate(tokens, 3);
    DisplayMessage display = new DisplayMessage(identifier.getCommand(), sender, content);
    return display.toString();
  }

  /**
   * method to convert to bytes
   * @return bytes converted
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
    sb.append(success);
    sb.append(splitBy);
    sb.append(message.length());
    sb.append(splitBy);
    sb.append(message);
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
    ConnectResponse that = (ConnectResponse) o;
    return success == that.success && Objects.equals(message, that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, message);
  }
}
