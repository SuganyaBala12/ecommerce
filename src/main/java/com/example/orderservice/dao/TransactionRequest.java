package com.example.orderservice.dao;

import com.example.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Order order;

    private Payment payment;
}
