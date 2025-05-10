package com.davinchicoder.spring_boot_async_template_community.application;

public interface Handler<T> {
    void handle(T request);
}
