package com.david.kafka.service;

import com.david.kafka.config.Constant;
import com.david.kafka.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = Constant.TOPIC, groupId = Constant.GROUP_ID, containerFactory = "userListener")
    public void consumeMessage(User user){
        System.out.println(user);
    }

}
