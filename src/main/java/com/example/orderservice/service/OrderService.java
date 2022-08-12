package com.example.orderservice.service;

import com.example.orderservice.dao.Payment;
import com.example.orderservice.dao.TransactionRequest;
import com.example.orderservice.dao.TransactionResponse;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse save(TransactionRequest request){
        String message = "";
        request.getPayment().setOrderId(request.getOrder().getId());
        request.getPayment().setPrice(request.getOrder().getPrice());
        orderRepository.save(request.getOrder());
        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",request.getPayment(),Payment.class);
        message = paymentResponse.getPaymentStatus().equals("success")?"Payment done successfully":"Issue with payment api";
        return new TransactionResponse(request.getOrder(),paymentResponse.getPrice(),paymentResponse.getTransactionId(),message);
    }
}
