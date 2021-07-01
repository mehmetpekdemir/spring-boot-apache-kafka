package com.mehmetpekdemir.apachekafka.controller;

import com.mehmetpekdemir.apachekafka.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final Producer producer;

    @PostMapping
    public void sendMessage(@RequestParam("message") String message) {
        producer.sendMessage(message);
    }

}
