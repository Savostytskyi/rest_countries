package commons;

/**
 * @author Anton_Savostytskyi on 12/10/2015.
 */
public class SoutReport {

  public static void soutServiceAndDbResponse (String restResponse, String dbResponse) {
    System.out.println("----------------Values from database (expected result)-------------------");
    System.out.println(dbResponse);
    System.out.println("----------------Values from service (actual result)----------------------");
    System.out.println(restResponse);
  }

}
