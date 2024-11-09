package com.david.kafka.config;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public TestRestTemplate testRestTemplate() {

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder()
                .defaultHeader("Content-Type", "application/json")
                .rootUri("http://localhost:8080");

        return new TestRestTemplate(restTemplateBuilder);

    }

}
