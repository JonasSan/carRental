package com.rental.carRental.repository;

import com.rental.carRental.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Integer> {   //int or string here?

    public Order findById (String id);
    public List<Order> findByCustomerNumber (int customerNumber);
}
