package com.david.kafka.service;

import com.david.kafka.config.Constant;
import com.david.kafka.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @RetryableTopic(attempts = "4", exclude = {NullPointerException.class}, backoff = @Backoff(delay = 3000, multiplier = 1.5, maxDelay = 15000))
    @KafkaListener(topics = "${app.topic}", groupId = "${app.group.id}", containerFactory = "userListener")
    public void consumeMessage(ConsumerRecord<String, User> consumerRecord ){

        User user = consumerRecord.value();

        if (user.getAge() < 18) throw new RuntimeException("Invalid age");
        log.info("Received message = [{}]", user);

    }

    @DltHandler
    public void listenDLT(ConsumerRecord<String, User> consumerRecord){
        User user = consumerRecord.value();

        log.info("DLT Received: {}, topic {}, offset {}",user.toString(), consumerRecord.topic(), consumerRecord.offset());

    }

}
