package com.epam.qa.cdp.restcountries.api.model;

public class Country extends Entity {

  private String name;
  private String capital;
  private Integer population;
  private String currency;

  public Country(Integer id, String name, String capital, Integer population, String currency) {
    super.setId(id);
    this.name = name;
    this.capital = capital;
    this.population = population;
    this.currency = currency;
  }

  public Country() {
  }

  //setters section

  public void setName(String name) {
    this.name = name;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  //getters section

  public String getName() {
    return name;
  }

  public String getCapital() {
    return capital;
  }

  public Integer getPopulation() { return population;}

  public String getCurrency() {
    return currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Country)) {
      return false;
    }
    Country country = (Country) o;
    if (!name.equals(country.name)) {
      return false;
    }
    if (!capital.equals(country.capital)) {
      return false;
    }
    if (!population.equals(country.population)) {
      return false;
    }
    return currency.equals(country.currency);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + capital.hashCode();
    result = 31 * result + population.hashCode();
    result = 31 * result + currency.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Country{" +
           "name='" + name + '\'' +
           ", capital='" + capital + '\'' +
           ", population=" + population +
           ", currency='" + currency + '\'' +
           '}';
  }
}
