package com.epam.training.dao;

import java.util.List;

/**
 * Created by rynffoll on 22.01.17.
 */
public interface BaseDAO<T, K> {
  // CRUD
  int create(T model) throws Exception;
  List<T> getAll() throws Exception;
  T getById(K id) throws Exception;
  int update(T model) throws Exception;
  int delete(T model) throws Exception;
  int deleteById(K id) throws Exception;
}
