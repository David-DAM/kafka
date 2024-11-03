package com.david.kafka.application.userCreated;

import com.david.kafka.application.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCreatedHandler implements Handler<UserCreatedRequest> {

    @Override
    public void handle(UserCreatedRequest request) {
        log.info("Handle UserCreatedRequest: {}", request.data().toString());
    }
}
