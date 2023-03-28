package assignment6;

/**
 * The type Invalid message format.
 */
public class UnknownMessageFormat extends IllegalArgumentException {

  /**
   * Instantiates a new Invalid message format.
   *
   * @param s the s
   */
  public UnknownMessageFormat(String s) {
    super(s);
  }
}
