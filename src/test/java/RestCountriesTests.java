import com.epam.qa.cdp.restcountries.api.database.dao.CountriesDao;
import com.epam.qa.cdp.restcountries.api.model.Country;
import com.epam.qa.cdp.restcountries.client.commons.Constants;
import com.epam.qa.cdp.restcountries.client.requests.Requests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import commons.SoutReport;

import static org.testng.Assert.assertEquals;

/**
 * @author Anton_Savostytskyi on 12/10/2015.
 */
public class RestCountriesTests {

  CountriesDao countriesDao = new CountriesDao();
  ObjectMapper mapper = new ObjectMapper();
  List<Country> countries;

  @Test
  public void checkGetAllDataRequest() throws IOException {
    String restResponse = Requests.sendClientGetRequest();
    StringWriter sw = new StringWriter();
    countries = countriesDao.findAll();
    mapper.writeValue(sw, countries);
    SoutReport.soutServiceAndDbResponse(restResponse, sw.toString());
    assertEquals(restResponse, sw.toString(), "ERROR: Incorrect response from REST service!");
  }

  @Test
  public void checkGetCountryBiIdRequest() throws IOException {
    String restResponse = Requests.sendClientGetRequestById(1);
    Country countryDb = countriesDao.findEntityById(1);
    Country countryRest = mapper.readValue(restResponse, Country.class);
    SoutReport.soutServiceAndDbResponse(countryRest.toString(), countryDb.toString());
    Assert.assertTrue(countryDb.equals(countryRest), "ERROR: Incorrect response from REST service!");
  }

  @Test
  public void checkPostCountryRequest() throws IOException {
    Integer restResponseCode = Requests.sendClientPostRequest(Constants.POST_JSON_STRING);
    assertEquals((int)restResponseCode, 201, "ERROR: response code is: " + restResponseCode);
    Country countryRest = mapper.readValue(Constants.POST_JSON_STRING, Country.class);
    countries = countriesDao.findAll();
    Country countryDb = countries.get(countries.size()-1);
    SoutReport.soutServiceAndDbResponse(countryRest.toString(), countryDb.toString());
    Assert.assertTrue(countryDb.equals(countryRest), "ERROR: Incorrect response from REST service!");
  }

  @Test(dependsOnMethods = "checkPostCountryRequest")
  public void checkPutCountryRequest() throws IOException {
    Integer restResponseCode = Requests.sendClientPutRequest(Constants.PUT_JSON_STRING);
    assertEquals((int)restResponseCode, 200, "ERROR: response code is: " + restResponseCode);
    Country countryRest = mapper.readValue(Constants.PUT_JSON_STRING, Country.class);
    countries = countriesDao.findAll();
    Country countryDb = countries.get(countries.size()-1);
    SoutReport.soutServiceAndDbResponse(countryRest.toString(), countryDb.toString());
    Assert.assertTrue(countryDb.equals(countryRest), "ERROR: Incorrect response from REST service!");
  }

  @Test(dependsOnMethods = "checkPutCountryRequest")
  public void checkDeleteCountryRequest() throws IOException {
    Country countryRest = mapper.readValue(Constants.POST_JSON_STRING, Country.class);
    Integer restResponseCode = Requests.sendClientDeleteRequest(countryRest.getId());
    assertEquals((int)restResponseCode, 200, "ERROR: response code is: " + restResponseCode);
    assertEquals(countriesDao.findEntityById(countryRest.getId()), null, "ERROR: Record wasn't removed from db!");
  }

}
