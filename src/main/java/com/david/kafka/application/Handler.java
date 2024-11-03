package com.david.kafka.application;

public interface Handler<T> {
    void handle(T request);
}
