package com.epam.training.web.controller;

import com.epam.training.domain.Car;
import com.epam.training.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by htim on 11.02.2017.
 */
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String listCars(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping("/cars/{vin}")
    public String showCar(@PathVariable String vin, Model model) {
        Car car = carService.findOne(vin);
        model.addAttribute("car", car);
        return "car";
    }


}
