package com.example.payment.service;

import com.example.orders.model.Order;
import com.example.payment.kafka.KafkaProducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayService {

    private final KafkaProducer kafkaProducer;

    public void payOrder(Order order) {
        log.info(String.format("Заказ -> %s оплачен", order.toString()));
        kafkaProducer.sendMessage(order);
    }
}
