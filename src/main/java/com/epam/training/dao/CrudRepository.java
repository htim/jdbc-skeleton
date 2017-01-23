package com.epam.training.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rynffoll on 22.01.17.
 */
// almost copy of Spring Data CrudRepository
// don't use this repository for implementing your repository classes
// create specific repository (see CarRepository)
public interface CrudRepository<T, K extends Serializable> {
  void delete(K id);
  void delete(T entity);
  boolean exists(K id);
  List<T> findAll();
  T findOne(K id);
  T save(T entity);
  List<T> save(List<T> entity);
}
