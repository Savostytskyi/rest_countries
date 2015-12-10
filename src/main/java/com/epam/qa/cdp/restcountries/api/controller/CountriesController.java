package com.epam.qa.cdp.restcountries.api.controller;

import com.epam.qa.cdp.restcountries.api.model.Country;
import com.epam.qa.cdp.restcountries.api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("v1/cdp")
public class CountriesController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Country> getCountries(){
        return countryService.getCountries();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Country getCountry(@PathVariable Integer id) {
        return countryService.getCountry(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Response createNewCountry(@RequestBody Country country) {
        countryService.addCountry(country);
        return Response.ok(country).build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    public Response updateCountry(@RequestBody Country country) {
        countryService.updateCountry(country);
        return Response.ok(country).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response deleteCurrency(@PathVariable Integer id) {
        countryService.removeCountry(id);
        return Response.ok(id).build();
    }

}
