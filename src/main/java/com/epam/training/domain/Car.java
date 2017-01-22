package com.epam.training.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Created by rynffoll on 18.01.17.
 */
public class Car {
  private String vin;
  private String manufacturer;
  private String country;
  private String brand;
  private String model;
  private double price;
  private int colorId;
  private Date date;

  public Car() {
  }

  public Car(String vin, String manufacturer, String country, String brand, String model, double price, int colorId, Date date) {
    this.vin = vin;
    this.manufacturer = manufacturer;
    this.country = country;
    this.brand = brand;
    this.model = model;
    this.price = price;
    this.colorId = colorId;
    this.date = date;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getColorId() {
    return colorId;
  }

  public void setColorId(int colorId) {
    this.colorId = colorId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return Double.compare(car.price, price) == 0 &&
            colorId == car.colorId &&
            Objects.equals(vin, car.vin) &&
            Objects.equals(manufacturer, car.manufacturer) &&
            Objects.equals(country, car.country) &&
            Objects.equals(brand, car.brand) &&
            Objects.equals(model, car.model) &&
            Objects.equals(date, car.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vin, manufacturer, country, brand, model, price, colorId, date);
  }

  @Override
  public String toString() {
    return "Car{" +
            "vin='" + vin + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", country='" + country + '\'' +
            ", brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", price=" + price +
            ", colorId=" + colorId +
            ", date=" + date +
            '}';
  }
}
