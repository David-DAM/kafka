package com.david.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = Constant.TOPIC, groupId = Constant.GROUP_ID)
    public void consumeMessage(String message){
        System.out.println(message);
    }

}
