package com.epam.qa.cdp.restcountries.api.database.dao;

import com.epam.qa.cdp.restcountries.api.model.Entity;
import java.util.List;

/**
 * @author Anton_Savostytskyi on 12/9/2015.
 */

  public abstract class AbstractDao<K,T extends Entity>{
    public abstract List<T> findAll();
    public abstract T findEntityById(K Id);
    public abstract void delete(K Id);
    public abstract T update(T entity);
    public abstract T insert(T entity);
}
