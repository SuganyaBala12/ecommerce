package com.example.orderservice.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    public static final String SEQUENCE_NAME = "payment_sequence";

    private int id;

    private String paymentStatus;

    private String transactionId;

    private int orderId;

    private double price;
}
