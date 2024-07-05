package com.example.payment.kafka;


import com.example.orders.model.Order;
import com.example.payment.service.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaConsumer {

    private final PayService payService;

    @KafkaListener(topics = "new_orders", groupId = "MyGroup_payment")
    public void consume(Order order) {
        log.info(String.format("Заказ -> %s получен из Kafka на оплату", order.toString()));
        payService.payOrder(order);
    }
}
