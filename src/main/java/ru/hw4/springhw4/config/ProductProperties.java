package ru.hw4.springhw4.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import ru.hw4.springhw4.model.Product;

import java.util.List;

@ConfigurationProperties("shop.properties")
@Getter
@Setter
public class ProductProperties {
    private List<Product> products;
}
