package com.epam.training.service;

import com.epam.training.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by rynffoll on 23.01.17.
 */
@Service
public class DemoService {

  private final CarService carService;

  @Autowired
  public DemoService(CarService carService) {
    this.carService = carService;
  }

  @PostConstruct
  public void init() {
    // put your code
    System.out.println("List of cars:");
    carService.findAll().forEach(System.out::println);

    System.out.println("Save car:");
    Car car = new Car("teslateslatesla1",
            "Tesla Motors",
            "US",
            "Tesla",
            "Model C",
            10_000_000.0,
            1,
            new Date());
    carService.save(car);

    System.out.println("List of cars after save:");
    carService.findAll().forEach(System.out::println);

    String country = "USA";
    double additionalValue = 1_000;
    System.out.println(String.format("Update cars from %s on %s", country, additionalValue));
    carService.updatePriceForSpecificCountry(country, additionalValue);

    System.out.println("List of cars after update:");
    carService.findAll().forEach(System.out::println);
  }

}
