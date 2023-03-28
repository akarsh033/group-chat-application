package assignment6;

/**
 * enum messageIdentifier
 */
public enum MessageIdentifier {
  /**
   * login
   */
  CONNECT_MESSAGE("19", "login"),
  /**
   * clientHandler
   */
  CONNECT_RESPONSE("20", "ClientHandler"),
  /**
   * logoff
   */
  DISCONNECT_MESSAGE("21", "logoff"),
  /**
   * who
   */
  QUERY_CONNECTED_USERS("22", "who"),
  /**
   * clientHandler
   */
  QUERY_USER_RESPONSE("23", "ClientHandler"),
  /**
   * all
   */
  BROADCAST_MESSAGE("24", "@all"),
  /**
   * user
   */
  DIRECT_MESSAGE("25", "@user"),
  /**
   * clientHandler
   */
  FAILED_MESSAGE("26", "ClientHandler"),
  /**
   * notUser
   */
  SEND_INSULT("27", "!user"),
  /**
   * clientHandler
   */
  DISCONNECT_RESPONSE("28", "ClientHandler");
  private String value;
  private String command;

  /**
   *the constructor
   * @param value value
   */
  MessageIdentifier(String value) {
    this.value = value;
  }

  /**
   *
   * @param value value
   * @param command command
   */
  MessageIdentifier(String value, String command) {
    this.value = value;
    this.command = command;
  }

  /**
   *
   * @return value
   */
  public String getValue() {
    return this.value;
  }

  /**
   *
   * @return value
   */
  public String getCommand() {
    return command;
  }


}