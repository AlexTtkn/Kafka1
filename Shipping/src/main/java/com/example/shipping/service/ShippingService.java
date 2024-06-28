package com.example.shipping.service;

import com.example.shipping.kafka.KafkaProducer;
import com.example.shipping.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShippingService {

    private final KafkaProducer kafkaProducer;

    public void shippingOrder(Order order) {
        log.info(String.format("Заказ собран -> %s ", order.toString()));
        kafkaProducer.sendMessage(order);
    }
}
