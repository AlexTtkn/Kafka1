package com.example.shipping.kafka;

import com.example.shipping.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(Order order) {
        log.info(String.format("Заказ отправлен клиенту -> %s", order.toString()));
        kafkaTemplate.send("sent_orders", "Заказ доставлен клиенту");
    }
}
