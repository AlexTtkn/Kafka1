package com.example.shipping.kafka;

import com.example.shipping.model.Order;
import com.example.shipping.service.ShippingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ShippingService shippingService;

    @KafkaListener(topics = "payed_orders", groupId = "MyGroup_shipment")
    public void consume(Order order) {
        log.info(String.format("Заказ -> %s пришел из Kafka на сборку", order.toString()));
        shippingService.shippingOrder(order);
    }
}
