package com.example.model.client;

import com.example.model.ProductDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseClient {
    RestTemplate restTemplate = new RestTemplate();

    public ProductDto[] getProducts() {
        return restTemplate.getForObject("http://localhost:8080/database/getAllProducts",ProductDto[].class);
    }

    public ProductDto saveProducts(ProductDto productDto){
        return restTemplate.postForObject("http://localhost:8080/database/saveProduct", productDto, ProductDto.class);
    }

    public void deleteProduct(Long id){
        restTemplate.delete("http://localhost:8080/database/delete",id);
    }
}

