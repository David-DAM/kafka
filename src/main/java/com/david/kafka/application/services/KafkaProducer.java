package com.david.kafka.application.services;

import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, GenericRecord> kafkaTemplate;

    public void sendMessage(String topic, GenericRecord genericRecord) {

        CompletableFuture<SendResult<String, GenericRecord>> send = kafkaTemplate.send(topic, UUID.randomUUID().toString(), genericRecord);

        send.whenComplete((result, exception) -> {
            if (exception == null) {
                log.info("Sent message = [{}], with offset = [{}]", genericRecord.toString(), result.getRecordMetadata().offset());
            } else {
                log.error("Unable to send message=[{}] due to: {}", genericRecord.toString(), exception.getMessage());
            }
        });
    }

}
