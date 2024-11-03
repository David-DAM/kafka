package com.david.kafka.infrastructure.kafka;

import com.david.kafka.infrastructure.kafka.util.MessagingUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.messaging.Message;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
@Component
public class KafkaConsumer implements Consumer<Message<GenericRecord>> {

    private final Map<String, EventSpecificConsumer<SpecificRecord>> specificConsumersMap;
    private final MessagingUtils messagingUtils;


    public KafkaConsumer(List<EventSpecificConsumer> specificConsumerList, MessagingUtils messagingUtils) {

        specificConsumersMap = specificConsumerList.stream().collect(Collectors.toMap(
                x -> ((ParameterizedType) x.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName(),
                y -> y
        ));
        this.messagingUtils = messagingUtils;
    }

    @RetryableTopic(attempts = "4", exclude = {NullPointerException.class}, backoff = @Backoff(delay = 3000, multiplier = 1.5, maxDelay = 15000))
    @KafkaListener(topics = "${app.topic}", groupId = "${app.group.id}", containerFactory = "kafkaListenerContainerFactory")
    @Override
    public void accept(Message<GenericRecord> genericRecordMessage) {

        try {
            log.info("Kafka Event message: {}", genericRecordMessage);

            SpecificRecord specificRecord = messagingUtils.getSpecificRecord(genericRecordMessage.getPayload());

            String schemaFullName = specificRecord.getClass().getTypeName();

            var specificConsumer = specificConsumersMap.get(schemaFullName);

            if (specificConsumer != null) {

                Message<SpecificRecord> specificRecordMessage = messagingUtils.buildMessage((SpecificRecord) genericRecordMessage.getPayload(), genericRecordMessage.getHeaders());
                specificConsumer.accept(specificRecordMessage);

            } else {
                log.warn("Kafka Event type with name [{}] does not exists", schemaFullName);
            }
        } catch (Exception e) {
            log.error("Error while processing event: [{}]", e.getMessage());
        }

    }

    @DltHandler
    public void listenDLT(ConsumerRecord<String, GenericRecord> genericRecord) {
        GenericRecord record = genericRecord.value();

        log.info("DLT Received: {}, topic {}, offset {}", record.toString(), genericRecord.topic(), genericRecord.offset());

    }

}
