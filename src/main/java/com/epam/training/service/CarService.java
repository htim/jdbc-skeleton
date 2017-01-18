package com.epam.training.service;

import com.epam.training.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by rynffoll on 18.01.17.
 */
@Service
public class CarService {

  private final CarDAO carDAO;

  @Autowired
  public CarService(CarDAO carDAO) {
    this.carDAO = carDAO;
  }

  @PostConstruct
  public void init() {
    carDAO.getAll().forEach(System.out::println);
  }
}
