package com.mehmetpekdemir.apachekafka.controller;

import com.mehmetpekdemir.apachekafka.service.ProducerService;
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

    private final ProducerService producerService;

    @PostMapping
    public void sendMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
    }

}
