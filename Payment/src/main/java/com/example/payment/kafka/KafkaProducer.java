package com.example.payment.kafka;

import com.example.orders.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(Order order) {
        log.info(String.format("Заказ отправлен на сборку -> %s", order.toString()));
        Message<Order> message = MessageBuilder
                .withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, "payed_orders")
                .build();
        kafkaTemplate.send(message);
    }
}
