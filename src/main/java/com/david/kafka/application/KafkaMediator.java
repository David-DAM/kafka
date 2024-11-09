package com.david.kafka.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class KafkaMediator {

    Map<String, Handler> handlersMap;

    public KafkaMediator(List<Handler> handlerList) {
        handlersMap = handlerList.stream().collect(Collectors.toMap(
                x -> ((ParameterizedType) x.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName(),
                Function.identity()
        ));
    }

    public <T> void mediate(T request) {

        Handler<T> handler = handlersMap.get(request.getClass().getTypeName());

        if (handler != null) {
            handler.handle(request);
        } else {
            log.error("No handler registered for request type: {}", request.getClass());
        }
    }
}
