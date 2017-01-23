package com.epam.training.service;

import com.epam.training.dao.CarRepository;
import com.epam.training.dao.impl.CarRepositoryImpl;
import com.epam.training.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rynffoll on 18.01.17.
 */
@Service
public class CarService {

  private final CarRepository carRepository;
  private final PlatformTransactionManager txManager;

  @Autowired
  public CarService(CarRepositoryImpl carDAO, PlatformTransactionManager txManager) {
    this.carRepository = carDAO;
    this.txManager = txManager;
  }

  public void delete(String id) {
    carRepository.delete(id);
  }

  public void delete(Car entity) {
    delete(entity.getVin());
  }

  public boolean exists(String id) {
    return carRepository.exists(id);
  }

  public List<Car> findAll() {
    return carRepository.findAll();
  }

  public Car findOne(String id) {
    return carRepository.findOne(id);
  }

  public List<Car> findByCountry(String country) {
    return carRepository.findByCountry(country);
  }

  public Car save(Car entity) {
    return carRepository.save(entity);
  }

  @Transactional
  public List<Car> updatePriceForSpecificCountry(String country, double additionValue) {
    List<Car> cars = carRepository.findByCountry(country);
    cars.forEach(c -> c.setPrice(c.getPrice() + additionValue));
    carRepository.save(cars);
    return cars;
  }
}
