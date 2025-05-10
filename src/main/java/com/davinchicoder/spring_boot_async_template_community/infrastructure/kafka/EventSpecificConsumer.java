package com.davinchicoder.spring_boot_async_template_community.infrastructure.kafka;

import org.apache.avro.specific.SpecificRecord;
import org.springframework.messaging.Message;

public interface EventSpecificConsumer<T extends SpecificRecord> {

    void accept(Message<T> genericRecordMessage);
}
