package com.epam.training.dao.impl;

import com.epam.training.dao.CarDAO;
import com.epam.training.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.naming.OperationNotSupportedException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by rynffoll on 18.01.17.
 */
@Repository
public class CarDAOImpl implements CarDAO {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public CarDAOImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  public List<Car> getAll() {
    return jdbcTemplate.query("SELECT * FROM cars", this::mapRow);
  }

  @Override
  public Car getById(String id) {
    return jdbcTemplate.queryForObject("SELECT * FROM cars WHERE vin = ?", this::mapRow, id);
  }

  @Override
  public int update(Car model) throws Exception {
    throw new OperationNotSupportedException();
  }

  @Override
  public int delete(Car model) {
    return deleteById(model.getVin());
  }

  @Override
  public int deleteById(String id) {
    return jdbcTemplate.update("DELETE FROM cars WHERE vin = ?", id);
  }

  public int create(Car car) {
    // creating map using class field name as map key and class field value as map value
    SqlParameterSource params = new BeanPropertySqlParameterSource(car);
    return namedParameterJdbcTemplate
            .update("INSERT INTO cars VALUES(:vin, :manufacturer, :country, :brand, :model, :price, :colorId, :date)",
                    params);
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
