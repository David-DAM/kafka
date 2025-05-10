package com.davinchicoder.spring_boot_async_template_community.infrastructure.api;

import com.davinchicoder.spring_boot_async_template_community.application.services.KafkaProducer;
import com.davinchicoder.spring_boot_async_template_community.infrastructure.events.UserCreated;
import com.davinchicoder.spring_boot_async_template_community.infrastructure.kafka.config.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/publish/user")
    public ResponseEntity<String> sendMessage(@RequestBody UserCreated user) {

        kafkaProducer.sendMessage(Constant.TOPIC, user);

        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }

}
