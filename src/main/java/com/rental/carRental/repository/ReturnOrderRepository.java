package com.rental.carRental.repository;

import com.rental.carRental.domain.Order;
import com.rental.carRental.domain.ReturnOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReturnOrderRepository extends MongoRepository<ReturnOrder, Integer> {

    public ReturnOrder findById (String id);
    public List<ReturnOrder> findByCompareId (String compareId);
}
