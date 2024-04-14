package com.david.kafka.service;

import com.david.kafka.config.Constant;
import com.david.kafka.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class Producer {

    private static final Logger log = LoggerFactory.getLogger(Producer.class);
    @Autowired
    private KafkaTemplate<String,User> kafkaTemplate;

    public void sendMessage(User user){
        CompletableFuture<SendResult<String, User>> send = kafkaTemplate.send(Constant.TOPIC, UUID.randomUUID().toString(), user);

        send.whenComplete((result, exception) -> {
            if (exception == null){
                log.info("Sent message = [{}], with offset = [{}]",user.toString(),result.getRecordMetadata().offset());
            }else {
                log.error("Unable to send message=[{}] due to: {}",user.toString(), exception.getMessage());
            }
        });

    }

}
