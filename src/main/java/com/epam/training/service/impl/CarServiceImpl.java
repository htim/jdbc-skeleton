package com.epam.training.service.impl;

import com.epam.training.dao.impl.CarDAOImpl;
import com.epam.training.domain.Car;
import com.epam.training.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by rynffoll on 18.01.17.
 */
@Service
public class CarServiceImpl implements CarService {

  private final CarDAOImpl carDAO;
  private final PlatformTransactionManager txManager;

  @Autowired
  public CarServiceImpl(CarDAOImpl carDAO, PlatformTransactionManager txManager) {
    this.carDAO = carDAO;
    this.txManager = txManager;
  }

  private TransactionStatus createTransaction(String name, int propagationBehavior) {
    DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
    transactionDefinition.setName(name);
    transactionDefinition.setPropagationBehavior(propagationBehavior);

    return txManager.getTransaction(transactionDefinition);
  }

  @Override
  public void create(Car model) {
    TransactionStatus transactionStatus = createTransaction("Insert car transaction", TransactionDefinition.PROPAGATION_REQUIRED);
    try {
      carDAO.create(model);
      txManager.commit(transactionStatus);
    } catch (Exception e) {
      txManager.rollback(transactionStatus);
      throw e;
    }
  }

  @Override
  public List<Car> getAll() {
    return carDAO.getAll();
  }

  @Override
  public Car getById(String id) {
    return carDAO.getById(id);
  }

  @Override
  public void update(Car model) throws Exception {
    TransactionStatus transactionStatus = createTransaction("Update car", TransactionDefinition.PROPAGATION_REQUIRED);
    try {
      carDAO.update(model);
      txManager.commit(transactionStatus);
    } catch (Exception e) {
      txManager.rollback(transactionStatus);
      throw e;
    }
  }

  @Override
  public void delete(Car model) {
    TransactionStatus transactionStatus = createTransaction("Delete car", TransactionDefinition.PROPAGATION_REQUIRED);
    try {
      carDAO.delete(model);
      txManager.commit(transactionStatus);
    } catch (Exception e) {
      txManager.rollback(transactionStatus);
      throw e;
    }
  }

  @Override
  public void deleteById(String id) {
    TransactionStatus transactionStatus = createTransaction("Delete car", TransactionDefinition.PROPAGATION_REQUIRED);
    try {
      carDAO.deleteById(id);
      txManager.commit(transactionStatus);
    } catch (Exception e) {
      txManager.rollback(transactionStatus);
      throw e;
    }
  }

  @PostConstruct
  public void init() {
    System.out.println("Cars:");
    getAll().forEach(System.out::println);

    System.out.println("Insert car:");
    Car car = new Car("teslateslatesla1",
            "Tesla Motors",
            "US",
            "Tesla",
            "Model C",
            10_000_000.0,
            1,
            new Date());
    create(car);

    System.out.println("Cars (after insert):");
    getAll().forEach(System.out::println);
  }
}
