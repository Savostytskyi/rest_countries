package com.epam.qa.cdp.restcountries.api.database.dao;

import com.epam.qa.cdp.restcountries.api.database.connection.ConnectorDB;
import com.epam.qa.cdp.restcountries.api.model.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton_Savostytskyi on 12/9/2015.
 */
public class CountriesDao extends AbstractDao<Integer, Country> {

  private Connection cn = null;
  private Statement st = null;
  private PreparedStatement ps = null;
  public static final String SQL_SELECT_ALL_COUNTRIES = "SELECT * FROM countries_info";
  public static final String SQL_SELECT_COUNTRY_BY_ID = "SELECT * FROM countries_info WHERE id = ?";
  public static final String SQL_INSERT_COUNTRY = "INSERT INTO `countries_info` (`id`, `name`, `capital`, `population`, `currency`) VALUES (?, ?, ?, ?, ?)";
  public static final String SQL_DELETE_COUNTRY = "DELETE FROM `countries_info` WHERE id = ?";
  public static final String SQL_UPDATE_COUNTRY = "UPDATE `countries_info` SET `name` = ?, `capital` = ?, `population` = ?, `currency` = ? WHERE `id` = ?";

  @Override
  public List<Country> findAll() {
    List<Country> countries = new ArrayList<Country>();
    try {
      cn = ConnectorDB.getConnection();
      st = cn.createStatement();
      ResultSet rs = st.executeQuery(SQL_SELECT_ALL_COUNTRIES);
      while (rs.next()) {
        Country country = new Country();
        country.setId(rs.getInt(1));
        country.setName(rs.getString(2));
        country.setCapital(rs.getString(3));
        country.setPopulation(rs.getInt(4));
        country.setCurrency(rs.getString(5));
        countries.add(country);
      }
    } catch (SQLException e) {
      System.err.println("SQL Exeption (request or table failed):" + e);
    } finally {
      closeConnection();
    }
    return countries;
  }

  @Override
  public Country findEntityById(Integer id) {
    Country country = null;
    try {
      cn = ConnectorDB.getConnection();
      String query = SQL_SELECT_COUNTRY_BY_ID;
      ps = cn.prepareStatement(query);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        country = new Country();
        country.setId(rs.getInt(1));
        country.setName(rs.getString(2));
        country.setCapital(rs.getString(3));
        country.setPopulation(rs.getInt(4));
        country.setCurrency(rs.getString(5));
      }
    } catch (Exception e) {
      System.err.println("SQL Exeption (request or table failed):" + e);
    } finally {
      closeConnection();
    }
    return country;
  }

  @Override
  public void delete(Integer id) {
    try {
      cn = ConnectorDB.getConnection();
      String query = SQL_DELETE_COUNTRY;
      ps = cn.prepareStatement(query);
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (Exception e) {
      System.err.println("SQL Exeption (request or table failed):" + e);
    } finally {
      closeConnection();
    }
  }

  @Override
  public Country insert(Country country) {
    try {
      cn = ConnectorDB.getConnection();
      String query = SQL_INSERT_COUNTRY;
      ps = cn.prepareStatement(query);
      ps.setInt(1, country.getId());
      ps.setString(2, country.getName());
      ps.setString(3, country.getCapital());
      ps.setInt(4, country.getPopulation());
      ps.setString(5, country.getCurrency());
      ps.executeUpdate();
    } catch (Exception e) {
      System.err.println("SQL Exeption (request or table failed):" + e);
    } finally {
      closeConnection();
    }
    return country;
  }

  @Override
  public Country update(Country country) {
    try {
      cn = ConnectorDB.getConnection();
      String query = SQL_UPDATE_COUNTRY;
      ps = cn.prepareStatement(query);
      ps.setString(1, country.getName());
      ps.setString(2, country.getCapital());
      ps.setInt(3, country.getPopulation());
      ps.setString(4, country.getCurrency());
      ps.setInt(5, country.getId());
      ps.executeUpdate();
    } catch (Exception e) {
      System.err.println("SQL Exeption (request or table failed):" + e);e.printStackTrace();
    } finally {
      closeConnection();
    }
    return country;
  }

  private void closeConnection() {
    try {
      if (cn != null) cn.close();
      if (st != null) st.close();
      if (ps != null) ps.close();
    } catch (SQLException e) {
      System.err.println("Can't close connection:" + e);
    }
  }
}
