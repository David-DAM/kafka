package com.david.kafka.service;

import com.david.kafka.config.Constant;
import com.david.kafka.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(User user){
        CompletableFuture<SendResult<String, Object>> send = kafkaTemplate.send(Constant.TOPIC, user);

    }

}
