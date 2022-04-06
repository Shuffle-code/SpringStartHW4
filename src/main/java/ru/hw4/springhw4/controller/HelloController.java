package ru.hw4.springhw4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import ru.hw4.springhw4.config.ProductProperties;
import ru.hw4.springhw4.model.Product;
import ru.hw4.springhw4.service.ProductService;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final ProductProperties properties;
    private final ProductService service;


    @GetMapping("/hello")
    public String helloJsp(Model model){
//        throw new RuntimeException("test Exception");
        if(!CollectionUtils.isEmpty(properties.getProducts())){
            model.addAttribute("prd", properties.getProducts().toString());
//        model.addAttribute("prd", "properties.getProduct().toString()");
        }
            return "hello";
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleRuntimeException(RuntimeException e){
        return "So sad, but .... fail";
    }

//    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @GetMapping("/products/add")
    public String showCreateForm(Model model) {
//        model.addAttribute("product", "properties.getProduct().toString()");
        model.addAttribute("product", new Product());
        return "add-product";
    }


    @RequestMapping(path = "/products/add", method = RequestMethod.POST)
    public String fillForm(Product product) {
        service.saveProduct(product);
        return "redirect:/products";
    }

//    @RequestMapping
    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "list-product";
    }

}
