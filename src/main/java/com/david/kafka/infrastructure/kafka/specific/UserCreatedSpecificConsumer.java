package com.david.kafka.infrastructure.kafka.specific;

import com.david.kafka.domain.User;
import com.david.kafka.infrastructure.kafka.EventSpecificConsumer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedSpecificConsumer implements EventSpecificConsumer<User> {

    @Override
    public void accept(Message<User> genericRecordMessage) {
        System.out.println("Consumed message: " + genericRecordMessage.getPayload());
    }
}
