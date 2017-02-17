package com.epam.training.web.api.controller;

import com.epam.training.domain.Car;
import com.epam.training.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Timur_Khudiakov on 2/17/2017.
 */
@RestController
@RequestMapping("/api/cars/")
public class CarRestController {

    @Autowired
    private CarService carService;

    @GetMapping("/{vin}")
    public Car getCarByVin(@PathVariable String vin) {
        Car car = carService.findOne(vin);
        return car;
    }
}
