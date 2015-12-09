package com.epam.qa.cdp.restcountries.api.database.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Anton_Savostytskyi on 12/9/2015.
 */

public class ConnectorDB {
  public static Connection getConnection() throws SQLException{
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    ResourceBundle resource= ResourceBundle.getBundle("countriesdb");
    String url= resource.getString("db.url");
    String user=resource.getString("db.user");
    String pass=resource.getString("db.password");
    return DriverManager.getConnection(url,user,pass);
  }


}
