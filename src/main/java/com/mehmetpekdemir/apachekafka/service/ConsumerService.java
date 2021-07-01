package com.mehmetpekdemir.apachekafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Slf4j
@Service
public class ConsumerService {

    private CountDownLatch latch = new CountDownLatch(1);
    private String payload;

    @KafkaListener(topics = "send_message", groupId = "group_id")
    public void consumeMessage(String message) {
        log.info(String.format("#### -> Consumed message -> %s", message));
        payload = message;
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public String getPayload() {
        return payload;
    }

}
