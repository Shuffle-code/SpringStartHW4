package ru.hw4.springhw4.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @ConditionalOnProperty("test.properties")
    @Bean
    public String testBean(){
        System.out.println("test");
        return "test";
    }
}
