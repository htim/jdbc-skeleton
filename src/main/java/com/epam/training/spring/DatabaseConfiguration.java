package com.epam.training.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by rynffoll on 18.01.17.
 */
@Configuration
public class DatabaseConfiguration {

  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String user;
  @Value("${spring.datasource.password}")
  private String password;

  // If you use spring-boot-starter-jdbc
  // DataSource/JdbcTemplate/NamedJdbcTemplate already exists

  // next line means that spring will inject props as class fields using setters
//  @ConfigurationProperties(prefix = "spring.datasource")
//  @Bean
//  public DataSource dataSource() {
//    return new DriverManagerDataSource();
//  }

  @Bean
  public DataSource dataSource() {
    return new DriverManagerDataSource(url, user, password);
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource ds) {
    return new JdbcTemplate(ds);
  }

  @Bean
  public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource ds) {
    return new NamedParameterJdbcTemplate(ds);
  }

}
