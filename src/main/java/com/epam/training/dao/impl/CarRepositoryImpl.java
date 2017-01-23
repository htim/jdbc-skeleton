package com.epam.training.dao.impl;

import com.epam.training.dao.CarRepository;
import com.epam.training.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by rynffoll on 18.01.17.
 */
@Repository
@Transactional
public class CarRepositoryImpl implements CarRepository {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public CarRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  @Override
  public void delete(String id) {
    jdbcTemplate.update("DELETE FROM cars WHERE vin = ?", id);

  }

  @Override
  public void delete(Car entity) {
    delete(entity.getVin());
  }

  @Override
  public boolean exists(String id) {
    Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM cars WHERE vin = ?", Integer.class, id);
    return count != null && count > 0;
  }

  @Override
  public List<Car> findAll() {
    return jdbcTemplate.query("SELECT * FROM cars", this::mapRow);
  }

  @Override
  public Car findOne(String id) {
    return jdbcTemplate.queryForObject("SELECT * FROM cars WHERE vin = ?", this::mapRow, id);
  }

  @Override
  public List<Car> findByCountry(String country) {
    return jdbcTemplate.query("SELECT * FROM cars WHERE country = ?", this::mapRow, country);
  }

  @Override
  // NOTE: method must contain some logic for update entity
  public Car save(Car entity) {
    // creating map using class field name as map key and class field value as map value
    SqlParameterSource params = new BeanPropertySqlParameterSource(entity);
    namedParameterJdbcTemplate
            .update("INSERT INTO cars VALUES(:vin, :manufacturer, :country, :brand, :model, :price, :colorId, :date)",
                    params);
    // I don't have generated id -> I return entity without changes
    // if you have generated id you will use KeyHolder
    return entity;
  }

  @Override
  public List<Car> save(List<Car> entity) {
    throw new UnsupportedOperationException();
  }

  private Car mapRow(ResultSet rs, int rowNum) throws SQLException {
    Car car = new Car();
    car.setVin(rs.getString("vin"));
    car.setManufacturer(rs.getString("manufacturer"));
    car.setCountry(rs.getString("country"));
    car.setBrand(rs.getString("brand"));
    car.setModel(rs.getString("model"));
    car.setPrice(rs.getDouble("price"));
    car.setDate(rs.getDate("date"));
    car.setColorId(rs.getInt("color_id"));
    return car;
  }
}
