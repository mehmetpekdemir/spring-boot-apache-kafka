package com.mehmetpekdemir.apachekafka.controller;

import com.mehmetpekdemir.apachekafka.service.ConsumerService;
import com.mehmetpekdemir.apachekafka.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(partitions = 1, topics = {"send_message"})
class KafkaControllerIT {

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private ProducerService producerService;

    @Test
    void given_embedded_kafka_broker_when_sending_to_simple_producer_then_message_received() throws InterruptedException {
        producerService.sendMessage("Hello World !");

        consumerService.getLatch().await(10000, TimeUnit.MILLISECONDS);

        assertThat(consumerService.getLatch().getCount()).isEqualTo(0);
        assertThat(consumerService.getPayload()).isEqualTo("Hello World !");
    }

}