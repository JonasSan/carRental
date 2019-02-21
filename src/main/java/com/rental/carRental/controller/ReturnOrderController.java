package com.rental.carRental.controller;

import com.rental.carRental.domain.Order;
import com.rental.carRental.domain.ReturnOrder;
import com.rental.carRental.repository.OrderRepository;
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


import java.util.List;

import java.util.List;
import java.util.Optional;

@Controller
public class ReturnOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ReturnOrderController.class);

    @Autowired
    private ReturnOrderRepository returnOrderRepository;
    private OrderRepository orderRepository;

    public ReturnOrderController(ReturnOrderRepository returnorderRepository, OrderRepository orderRepository) {
        this.returnOrderRepository = returnOrderRepository;
        this.orderRepository = orderRepository;
    }


    @PostMapping("/return/submit")
    public String returnOrder1(RedirectAttributes redirectAttributes, @RequestParam String compareId, @RequestParam String dateReturn,
                               @RequestParam int kmCountAfter) {
        System.out.println("vi är här!");
        ReturnOrder returnOrder = new ReturnOrder(compareId, dateReturn, kmCountAfter);
        returnOrderRepository.save(returnOrder);
        logger.info("Return registered");
        redirectAttributes
                .addAttribute(returnOrder)
                .addFlashAttribute("success", true);

//
//        List<ReturnOrder> latestReturnOrder = returnOrderRepository.findAll();
//
//        int max = 0;
//        for (ReturnOrder currentReturnOrder : latestReturnOrder) {
//            if (currentReturnOrder.getId() > max)
//                max = currentAd.getId();
//        }
//        System.out.println(max);
//        Optional<ad> latestAd = adRepository.findById(max);
//
//        if (latestAd.isPresent()) {
//            model.addAttribute("latestAd", latestAd.get());
//            System.out.println(latestAd.get());
//            return "annonsvy";
//        } else {
//            return "newAd";
//        }
//
//




        return "redirect:/returned";
    }

    @GetMapping("/returned")
    public String annonserTest(Model model) {
        List<ReturnOrder> allReturnOrders = returnOrderRepository.findAll();
        model.addAttribute("allReturnOrders", allReturnOrders);
        List<Order> allOrders = orderRepository.findAll();
        model.addAttribute("allOrders", allOrders);
        return "returned";
    }
//
//    @GetMapping("/return")
//    public String returnview2 (Model model) {
//        List<ReturnOrder> allReturnOrders = returnOrderRepository.findAll();
//        model.addAttribute("allReturnOrders", allReturnOrders);
//        List<Order> allOrders = orderRepository.findAll();
//        model.addAttribute("allOrders", allOrders);
//        return "return";
//    }

}
