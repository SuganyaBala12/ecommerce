package com.example.orderservice.dao;

import com.example.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Order order;

    private double price;

    private String transactionId;

    private String message;

}
