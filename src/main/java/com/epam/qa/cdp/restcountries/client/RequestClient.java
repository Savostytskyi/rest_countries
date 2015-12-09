package com.epam.qa.cdp.restcountries.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import static com.epam.qa.cdp.restcountries.client.commons.Constants.servicePath;

/**
 * @author Anton_Savostytskyi on 12/9/2015.
 */
public class RequestClient {

  public static void main(String[] args) {

  // sendClientGetRequest();

    //new CountriesDao().delete(101);
   // sendClientDeleteRequest();
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

  public static void sendClientPostRequest() {
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath);
      String input = "{\"id\":101,\"name\":\"Austsdfria\",\"capital\":\"Vienna\",\"population\":0,\"currency\":\"Euro\"}";
      ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
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

/*  public static void sendClientDeleteRequest() {
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(servicePath).path("11");
      String input = "{\"id\":11,\"name\":\"Austsdfria\",\"capital\":\"Vienna\",\"population\":0,\"currency\":\"Euro\"}";

      ClientResponse response = webResource.delete();
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
  }*/
  }

