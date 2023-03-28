package assignment6;

//import assignment6.message.MessageIdentifier;
import static assignment6.Server.ONE;
import static assignment6.Server.TWO;
import static assignment6.Server.ZERO;

import assignment6.message.BroadcastMessage;
import assignment6.message.ConnectMessage;
import assignment6.message.ConnectResponse;
import assignment6.message.DirectMessage;
import assignment6.message.DisconnectMessage;
import assignment6.message.DisconnectResponse;
import assignment6.message.FailedMessage;
import assignment6.message.InsultMessage;
import assignment6.message.QueryMessage;
import assignment6.message.QueryResponse;

/**
 * Class to handle user interface
 */
public class Cli {

  /**
   * Parse user input string.
   *
   * @param userName the user name
   * @param input    the input
   * @return the string
   */
  public static String parseUserInput(String userName, String input) {
    String DELIMITER = " ";
    String[] tokens = input.split(DELIMITER);
    String command = tokens[ZERO];
    if (command.equals("?")) {
      Cli.displayCommandLineOptions();
      return "";
    }
    MessageIdentifier commandEnum = null;
    for (MessageIdentifier item : MessageIdentifier.values()) {
      if (command.equals(item.getCommand())) {
        commandEnum = item;
      }
    }
    byte[] res = null;
    if (commandEnum == null) {
      throw new UnknownMessageFormat(
          "Please send message in valid commands as per protocol of chat room!");
    }
    try {
      switch (commandEnum) {
        case CONNECT_MESSAGE: {
          return new ConnectMessage(userName).toString();
        }
        case DISCONNECT_MESSAGE: {
          return new DisconnectMessage(userName).toString();
        }
        case QUERY_CONNECTED_USERS: {
          return new QueryMessage(userName).toString();
        }
        case BROADCAST_MESSAGE: {
          String content = concatStringArr(tokens, ONE);
          return new BroadcastMessage(userName, content).toString();
        }
        case DIRECT_MESSAGE: {
          String recipient = tokens[ONE];
          String content = concatStringArr(tokens, TWO);
          return new DirectMessage(userName, recipient, content).toString();
        }
        case SEND_INSULT: {
          String recipient = tokens[ONE];
          return new InsultMessage(userName, recipient).toString();
        }
      }
      throw new UnknownMessageFormat("Please enter valid commands as per protocol of chat room!");
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new UnknownMessageFormat("Less arguments specified in commands!");
    }
  }

  /**
   * Parse response string.
   *
   * @param rawRes the raw res
   * @return the string
   */
  public static String parseResponse(String rawRes) {
    String DELIMITER = " ";
    String[] token = rawRes.split(DELIMITER);
    String valueCode = token[ZERO];
    MessageIdentifier messageIdentifier = null;
    for (MessageIdentifier iter : MessageIdentifier.values()) {
      if (iter.getValue().equals(valueCode)) {
        messageIdentifier = iter;
      }
    }
    if (messageIdentifier == null) {
      throw new UnknownMessageFormat(
          "Received invalid response");
    }
    switch (messageIdentifier) {
      case CONNECT_RESPONSE:
        return ConnectResponse.displayMessage(rawRes);
      case DIRECT_MESSAGE:
        return DirectMessage.displayMessage(rawRes);
      case BROADCAST_MESSAGE:
        return BroadcastMessage.displayMessage(rawRes);
      case QUERY_USER_RESPONSE:
        return QueryResponse.displayMessage(rawRes);
      case DISCONNECT_RESPONSE:
        return DisconnectResponse.displayMessage(rawRes);
      case FAILED_MESSAGE:
        return FailedMessage.displayMessage(rawRes);
    }
    throw new UnknownMessageFormat(
        "Received invalid response");
  }

  /**
   * Display command line options.
   */
  public static void displayCommandLineOptions() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("Chat Room Command Options:\n");
    buffer.append("?: show command line options\n");
    buffer.append("login: CONNECT_MESSAGE to the server\n");
    buffer.append("logoff: sends a DISCONNECT_MESSAGE to the server\n");
    buffer.append("who: sends a QUERY_CONNECTED_USERS to the server\n");
    buffer.append("@user: sends a DIRECT_MESSAGE to the specified user to the server\n");
    buffer.append(
        "@all: sends a BROADCAST_MESSAGE to the server, to be sent to all users connected\n");
    buffer.append(
        "!user: sends a SEND_INSULT message to the server, to be sent to the specified user");
    System.out.println(buffer.toString());
  }

  /**
   * Print welcome.
   *
   * @param userName the user name
   */
  public static void printWelcome(String userName) {
    System.out.println("Hi, " + userName);
    Cli.displayCommandLineOptions();
  }

  /**
   * Concate string arr string.
   *
   * @param tokens the tokens
   * @param start  the start
   * @return the string
   */
  public static String concatStringArr(String[] tokens, int start) {
    String res = "";
    for (int i = start; i < tokens.length; i++) {
      if (i != tokens.length - ONE) {
        res += tokens[i] + " ";
      } else {
        res += tokens[i];
      }
    }
    return res;
  }
}
