package com.mehmetpekdemir.apachekafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Slf4j
@Service
public class Consumer {

    @KafkaListener(topics = "send_message", groupId = "group_id")
    public void consumeMessage(String message) {
        log.info(String.format("#### -> Consumed message -> %s", message));
    }

}
