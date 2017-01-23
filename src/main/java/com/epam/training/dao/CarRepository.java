package com.epam.training.dao;

import com.epam.training.domain.Car;

import java.util.List;

/**
 * Created by rynffoll on 22.01.17.
 */
public interface CarRepository extends CrudRepository<Car, String> {
  List<Car> findByCountry(String country);
  // and other specific method for this entity
}
