package com.david.kafka.controller;

import com.david.kafka.service.Producer;
import com.david.kafka.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Producer producer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user){

        producer.sendMessage(user);

        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }

}
