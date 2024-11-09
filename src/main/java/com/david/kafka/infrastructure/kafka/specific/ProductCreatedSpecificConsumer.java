package com.david.kafka.infrastructure.kafka.specific;

import com.david.kafka.application.KafkaMediator;
import com.david.kafka.infrastructure.events.ProductCreated;
import com.david.kafka.infrastructure.kafka.EventSpecificConsumer;
import com.david.kafka.infrastructure.kafka.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductCreatedSpecificConsumer implements EventSpecificConsumer<ProductCreated> {

    private final KafkaMediator kafkaMediator;
    private final EventMapper eventMapper;

    @Override
    public void accept(Message<ProductCreated> genericRecordMessage) {
        log.info("Received ProductCreatedSpecificConsumer: {}", genericRecordMessage.getPayload());

    }
}
