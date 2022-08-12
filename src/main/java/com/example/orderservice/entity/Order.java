package com.example.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    public static final String SEQUENCE_NAME = "order_sequence";

    @Id
    private int id;

    private String name;

    private int qty;

    private double price;
}
