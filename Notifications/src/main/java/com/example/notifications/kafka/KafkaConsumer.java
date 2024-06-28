package com.example.notifications.kafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaConsumer {

    @KafkaListener(topics = "sent_orders", groupId = "MyGroup_notification")
    public void consume(String message) {
        log.info(message);
    }
}
