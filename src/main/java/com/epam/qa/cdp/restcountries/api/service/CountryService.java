package com.epam.qa.cdp.restcountries.api.service;

import com.epam.qa.cdp.restcountries.api.database.dao.CountriesDao;
import com.epam.qa.cdp.restcountries.api.model.Country;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryService {

    private List<Country> countries;
    private CountriesDao countriesDao;
    private Country country;

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
        country = countriesDao.findEntityById(id);
        return country;
    }

    public void addCountry(Country country) {
            countriesDao.insert(country);
    }

    public void removeCountry(Integer id) {
        countriesDao.delete(id);
    }

    public void updateCountry(Country country) {
        countriesDao.update(country);
    }
}
