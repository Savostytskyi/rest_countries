package com.epam.qa.cdp.restcountries.api.service;

import com.epam.qa.cdp.restcountries.api.database.dao.CountriesDao;
import com.epam.qa.cdp.restcountries.api.model.Country;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryService {

    private List<Country> countries;
    private CountriesDao countriesDao;

    @PostConstruct
    public void init() {
        countries = new ArrayList<Country>();
        countriesDao= new CountriesDao();
    }

    public List<Country> getCountries() {
        countries = countriesDao.findAll();
        return countries;
    }

    public Country getCountry(Integer id) {
        countries = countriesDao.findAll();
        return countries.get(id);
    }

    public void addCountry(Country country) {
            countriesDao.insert(country);
    }

    public void removeCountry(Integer id) {
        countriesDao.delete(id);
    }
}
