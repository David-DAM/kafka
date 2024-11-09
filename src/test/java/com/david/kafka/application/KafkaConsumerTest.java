package com.david.kafka.application;

import com.david.kafka.infrastructure.events.UserCreated;
import lombok.SneakyThrows;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import java.time.Duration;
import java.util.List;

@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class KafkaConsumerTest {

    @Autowired
    private KafkaTemplate<String, GenericRecord> kafkaTemplate;

    @Autowired
    private ConsumerFactory<String, GenericRecord> consumerFactory;

    private Consumer<String, GenericRecord> consumer;

    private final String TOPIC = "test-topic";

    @BeforeEach
    void setUp() {
        consumer = consumerFactory.createConsumer();
        consumer.subscribe(List.of(TOPIC));

        ConsumerRecords<String, GenericRecord> records;
        do {
            records = consumer.poll(Duration.ofMillis(500));
        } while (!records.isEmpty());
    }

    @AfterEach
    void tearDown() {
    }

    @SneakyThrows
    @Test
    void consumeMessage() {

        UserCreated userCreated = UserCreated.newBuilder()
                .setName("David")
                .setLastname("Jimenez")
                .setHeight(1.80)
                .setAge(24)
                .build();

        kafkaTemplate.send(TOPIC, userCreated);

        ConsumerRecords<String, GenericRecord> records = KafkaTestUtils.getRecords(
                consumer, Duration.ofSeconds(10L));

        Assertions.assertNotNull(records);
        Assertions.assertFalse(records.isEmpty());
        Assertions.assertEquals("David", records.iterator().next().value().get("name").toString());
    }
}