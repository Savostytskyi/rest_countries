package com.epam.qa.cdp.restcountries.client;

import com.epam.qa.cdp.restcountries.client.commons.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
import static com.epam.qa.cdp.restcountries.client.commons.Constants.servicePath;

/**
 * @author Anton_Savostytskyi on 12/9/2015.
 */
public class RequestClient {

  public static void main(String[] args) {
    //sendClientPostRequest();
    sendClientPutRequest(Constants.PUT_JSON_STRING);

  }

  public static void sendClientGetRequest() {
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath);
      ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }
      String output = response.getEntity(String.class);
      System.out.println("Output from Server .... \n");
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void sendClientGetRequestById(Integer id) {
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath).path(Integer.toString(id));
      ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }
      String output = response.getEntity(String.class);
      System.out.println("Output from Server .... \n");
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void sendClientPostRequest(String json) {
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath);
     // String input = "{\"id\":102,\"name\":\"Austsdfria\",\"capital\":\"Vienna\",\"population\":70,\"currency\":\"Euro\"}";
      ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);
      if (response.getStatus() != 201) {
        throw new RuntimeException("Failed : HTTP error code : "
                                   + response.getStatus());
      }
      System.out.println("Output from Server .... \n");
      String output = response.getEntity(String.class);
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void sendClientPutRequest(String json) {
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath);
      String input = "{\"id\":104,\"name\":\"Austsdfria\",\"capital\":\"unknown\",\"population\":1100000,\"currency\":\"Euro\"}";
      ClientResponse response = webResource.type("application/json").put(ClientResponse.class, input);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
                                   + response.getStatus());
      }
      System.out.println("Output from Server .... \n");
      String output = response.getEntity(String.class);
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void sendClientDeleteRequest(Integer id) {
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath).path(Integer.toString(id));
      ClientResponse response = webResource.type(MediaType.TEXT_PLAIN).delete(ClientResponse.class);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }
      String output = response.getEntity(String.class);
      System.out.println("Output from Server .... \n");
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  }

