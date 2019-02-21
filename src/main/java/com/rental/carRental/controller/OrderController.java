package com.rental.carRental.controller;

import com.rental.carRental.domain.Order;

import com.rental.carRental.domain.ReturnOrder;
import com.rental.carRental.repository.OrderRepository;
//import jdk.vm.ci.meta.Local;
import com.rental.carRental.repository.ReturnOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller

public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @Autowired
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @GetMapping("/index")
    public String indexview() {
        return "index";
    }

    @GetMapping("/rent")
    public String rentview() {
        return "rent";
    }

    @GetMapping("/return")
    public String returnview() {
        return "return";
    }

//    @GetMapping("/returned")
//    public String returnedview() {
//        return "returned";
//
//    }

//    @GetMapping("/return/returnSubmit")
//    public String returnedview1() {
//        return "returned";
//    }

//    @GetMapping("/booking")
//    public String bookingview() {
//        return "booking";
//    }
//@GetMapping("/rent/submit")
//public String newOrder (Model model) {
//    model.addAttribute("order", new Order());
//    return "rent/submit";
//}

    @PostMapping("/index/submit")
    public String createOrder(RedirectAttributes redirectAttributes, @RequestParam int customerNumber, @RequestParam String carType,
                              @RequestParam String regNumber, @RequestParam String dateBooking, @RequestParam int kmCountBefore) {
        System.out.println("vi är här!");
        Order order1 = new Order(customerNumber, carType, regNumber, dateBooking, kmCountBefore);
        orderRepository.save(order1);
        logger.info("Car ordered");
        redirectAttributes
                .addAttribute(order1)
                .addFlashAttribute("success", true);

        return "redirect:/booking";
    }



    @GetMapping("/booking")
    public String annonserTest(Model model) {
        List<Order> allOrders = orderRepository.findAll();
        model.addAttribute("allOrders", allOrders);
        return "booking";
    }




}
