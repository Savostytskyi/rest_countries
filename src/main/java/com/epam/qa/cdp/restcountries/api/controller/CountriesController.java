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


@RestController
@RequestMapping("v1/countries")
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
    public void createNewCurrency(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCurrency(@PathVariable("id") Integer id) {
        countryService.removeCountry(id);
    }
}
