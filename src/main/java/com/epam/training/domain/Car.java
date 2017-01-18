package com.epam.training.domain;

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

  @Override
  public String toString() {
    return "Car{" +
            "vin='" + vin + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", country='" + country + '\'' +
            ", brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", price=" + price +
            '}';
  }
}
