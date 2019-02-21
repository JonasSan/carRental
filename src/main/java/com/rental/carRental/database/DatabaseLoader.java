package com.rental.carRental.database;


import com.rental.carRental.domain.Order;
import com.rental.carRental.domain.ReturnOrder;
import com.rental.carRental.repository.ReturnOrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rental.carRental.repository.OrderRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DatabaseLoader implements CommandLineRunner {


    private OrderRepository orderRepository;
    private ReturnOrderRepository returnOrderRepository;


    public DatabaseLoader(OrderRepository orderRepository, ReturnOrderRepository returnOrderRepository) {
        this.orderRepository=orderRepository;
        this.returnOrderRepository=returnOrderRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        System.out.println("You are here");

        this.orderRepository.deleteAll();
        this.returnOrderRepository.deleteAll();

        ReturnOrder returnOrder= new ReturnOrder("rirspier", "2938392", 897);
        this.returnOrderRepository.save(returnOrder);
        System.out.println(returnOrder.toString());

        Order order = new Order(4444,"smallCar","agh789", "2019-01-25T13:29",50000);
        this.orderRepository.save(order);
        System.out.println(order.toString());

        Order order2 = new Order(3453,"Van","sdg236","2019-01-25T13:29",5003463);
        this.orderRepository.save(order2);
        System.out.println(order2.toString());


        System.out.println("Test: find order by Number");
        System.out.println("--------------------------------");
        System.out.println(orderRepository.findByCustomerNumber(3453));
        System.out.println(returnOrderRepository.findByCompareId("rirspier"));


    }
}
