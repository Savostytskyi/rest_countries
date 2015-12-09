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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
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
