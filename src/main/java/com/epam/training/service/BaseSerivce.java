package com.epam.training.service;

import java.util.List;

/**
 * Created by rynffoll on 22.01.17.
 */
public interface BaseSerivce<T, K> {
  // CRUD
  void create(T model) throws Exception;
  List<T> getAll() throws Exception;
  T getById(K id) throws Exception;
  void update(T model) throws Exception;
  void delete(T model) throws Exception;
  void deleteById(K id) throws Exception;
}
