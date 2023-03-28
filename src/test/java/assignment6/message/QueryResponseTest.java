package assignment6.message;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import assignment6.ClientHandler;

import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Test;

class QueryResponseTest {
QueryResponse queryResponse;
QueryResponse queryResponse1;
  ConcurrentHashMap map;
  public QueryResponseTest() {
    map=new ConcurrentHashMap<String, ClientHandler>();
    map.put("test",new ClientHandler(null,1,null,null));
    map.put("test2",new ClientHandler(null,1,null,null));



    queryResponse = new QueryResponse("random",map);
    queryResponse1 = new QueryResponse("random1",map);


  }

  @Test
  void toBytes() {
    System.out.println(queryResponse.toBytes());
  }

  @Test
  void displayMessage() {
    System.out.println(queryResponse.displayMessage(queryResponse.toString()));
  }

  @Test
  void testToString() {
    System.out.println(queryResponse.toString());
  }

  @Test
  void testEquals() {
    assertTrue(queryResponse.equals(queryResponse));
    assertFalse(queryResponse.equals(queryResponse1));
    assertFalse(queryResponse1.equals(null));
  }

  @Test
  void testHashCode() {
    assertEquals(queryResponse.hashCode(),Objects.hashCode(queryResponse));
  }
}