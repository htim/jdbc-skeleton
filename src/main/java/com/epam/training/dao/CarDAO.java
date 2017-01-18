package com.epam.training.dao;

import com.epam.training.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by rynffoll on 18.01.17.
 */
@Repository
public class CarDAO {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public CarDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Car> getAll() {
    List<Car> cars = jdbcTemplate.query("SELECT * FROM cars", this::mapRow);
    return cars;
  }

  private Car mapRow(ResultSet rs, int rowNum) throws SQLException {
    Car car = new Car();
    car.setVin(rs.getString("vin"));
    car.setManufacturer(rs.getString("manufacturer"));
    car.setCountry(rs.getString("country"));
    car.setBrand(rs.getString("brand"));
    car.setModel(rs.getString("model"));
    car.setPrice(rs.getDouble("price"));
    return car;
  }
}
