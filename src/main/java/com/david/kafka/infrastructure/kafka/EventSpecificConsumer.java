package com.david.kafka.infrastructure.kafka;

import org.apache.avro.specific.SpecificRecord;
import org.springframework.messaging.Message;

public interface EventSpecificConsumer<T extends SpecificRecord> {

    void accept(Message<T> genericRecordMessage);
}
