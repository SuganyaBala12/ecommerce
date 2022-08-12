package com.example.orderservice.controller;

import com.example.orderservice.dao.TransactionRequest;
import com.example.orderservice.dao.TransactionResponse;
import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
        request.getOrder().setId(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
        return orderService.save(request);
    }
}
