package ru.hw4.springhw4.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hw4.springhw4.model.Product;
import ru.hw4.springhw4.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }


//    public Product getProductById(Integer id) {
//        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
//    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
