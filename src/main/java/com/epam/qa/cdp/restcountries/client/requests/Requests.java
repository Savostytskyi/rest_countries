package com.epam.qa.cdp.restcountries.client.requests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
import static com.epam.qa.cdp.restcountries.client.commons.Constants.servicePath;

/**
 * @author Anton_Savostytskyi on 12/9/2015.
 */
public class Requests {

  public static String sendClientGetRequest() {
    String output = null;
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath);
      ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }
      output = response.getEntity(String.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return output;
  }

  public static String sendClientGetRequestById(Integer id) {
    String output = null;
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath).path(Integer.toString(id));
      ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }
      output = response.getEntity(String.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return output;
  }

  public static Integer sendClientPostRequest(String jsonString) {
    Integer status = null;
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath);
      ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonString);
      status = response.getStatus();
      if (status != 201) {
        throw new RuntimeException("Failed : HTTP error code : "
                                   + response.getStatus());
      }
      System.out.println("Output from Server .... \n");
      String output = response.getEntity(String.class);
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return status;
  }

  public static Integer sendClientPutRequest(String jsonString) {
    Integer status = null;
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath);
     // String input = "{\"id\":101,\"name\":\"Austsdfria\",\"capital\":\"unknown\",\"population\":110,\"currency\":\"Euro\"}";
      ClientResponse response = webResource.type("application/json").put(ClientResponse.class, jsonString);
      status = response.getStatus();
      if (status != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
                                   + response.getStatus());
      }
      System.out.println("Output from Server .... \n");
      String output = response.getEntity(String.class);
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return status;
  }

  public static Integer sendClientDeleteRequest(Integer id) {
    Integer status = null;
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath).path(Integer.toString(id));
      ClientResponse response = webResource.type(MediaType.TEXT_PLAIN).delete(ClientResponse.class);
      status = response.getStatus();
      if (status != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }
      String output = response.getEntity(String.class);
      System.out.println("Output from Server .... \n");
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return status;
  }
}
