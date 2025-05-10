package com.davinchicoder.spring_boot_async_template_community.infrastructure.kafka.specific;

import com.davinchicoder.spring_boot_async_template_community.application.KafkaMediator;
import com.davinchicoder.spring_boot_async_template_community.infrastructure.events.ProductCreated;
import com.davinchicoder.spring_boot_async_template_community.infrastructure.kafka.EventSpecificConsumer;
import com.davinchicoder.spring_boot_async_template_community.infrastructure.kafka.mapper.EventMapper;
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
