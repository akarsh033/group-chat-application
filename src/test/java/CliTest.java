
import static org.junit.jupiter.api.Assertions.assertEquals;

import assignment6.Cli;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class CliTest {
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private static final PrintStream oriout = System.out;


  public CliTest() throws Exception {
    System.setOut(new PrintStream(outputStream));
  }

  @AfterAll
  public static void tearDown() throws Exception {
    System.setOut(oriout);
  }

  @Test
  public void parseUserInput() {
    assertEquals("19 2 ch", Cli.parseUserInput("ch", "login"));
  }

  @Test
  public void parseResponse() {
    String rawInput="25 3 shukla 5 ch 5 hello";
    assertEquals(" (login) shukla->ch: hello",Cli.parseResponse(rawInput));
  }

  @Test
  public void displayCommandLineOptions() {
    Cli.displayCommandLineOptions();
  }

  @Test
  public void printWelcome() {
    Cli.printWelcome("test");
  }

  @Test
  public void concatStringArr() {
    String[]strArr=new String[]{"a","b","c"};
    assertEquals(Cli.concatStringArr(strArr,1),"b c");
  }
}
