package com.david.kafka.infrastructure.kafka.specific;

import com.david.kafka.application.KafkaMediator;
import com.david.kafka.application.userCreated.UserCreatedCmd;
import com.david.kafka.application.userCreated.UserCreatedRequest;
import com.david.kafka.infrastructure.events.UserCreated;
import com.david.kafka.infrastructure.kafka.EventSpecificConsumer;
import com.david.kafka.infrastructure.kafka.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCreatedSpecificConsumer implements EventSpecificConsumer<UserCreated> {

    private final KafkaMediator kafkaMediator;
    private final EventMapper eventMapper;

    @Override
    public void accept(Message<UserCreated> genericRecordMessage) {
        log.info("Received UserCreatedSpecificConsumer: {}", genericRecordMessage.getPayload());
        UserCreatedCmd userCreatedCmd = eventMapper.map(genericRecordMessage.getPayload());
        kafkaMediator.mediate(new UserCreatedRequest(userCreatedCmd));
    }
}
