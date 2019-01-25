package com.rental.carRental.database;


import com.rental.carRental.domain.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rental.carRental.repository.OrderRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DatabaseLoader implements CommandLineRunner {


    private OrderRepository orderRepository;


    public DatabaseLoader(OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("You are here");

        this.orderRepository.deleteAll();

        Order order = new Order(4444,"smallCar","agh789", "2019-01-25T13:29",50000);
        this.orderRepository.save(order);
        System.out.println(order.toString());

        Order order2 = new Order(3453,"Van","sdg236","2019-01-25T13:29",5003463);
        this.orderRepository.save(order2);
        System.out.println(order2.toString());


        System.out.println("Test: find order by Number");
        System.out.println("--------------------------------");
        System.out.println(orderRepository.findByCustomerNumber(3453));





    }
}
