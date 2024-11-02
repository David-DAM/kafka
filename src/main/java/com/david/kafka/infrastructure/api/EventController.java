package com.david.kafka.infrastructure.api;

import com.david.kafka.application.kafka.KafkaProducer;
import com.david.kafka.domain.User;
import com.david.kafka.infrastructure.kafka.config.Constant;
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
    public ResponseEntity<String> sendMessage(@RequestBody User user) {

        kafkaProducer.sendMessage(Constant.TOPIC, user);

        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }

}
