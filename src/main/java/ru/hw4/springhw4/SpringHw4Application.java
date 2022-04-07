package ru.hw4.springhw4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.hw4.springhw4.config.ProductProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProductProperties.class)
public class SpringHw4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringHw4Application.class, args);
    }

}
