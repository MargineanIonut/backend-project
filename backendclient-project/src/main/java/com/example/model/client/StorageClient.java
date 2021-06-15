package com.example.model.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class StorageClient {
    public String findResourceByNameAndShopCode(String resourceName, String shopCode){
        String api = UriComponentsBuilder.fromHttpUrl("http://localhost:8080")
                .fragment("/api/backend/resources/resource")
                .queryParam("resourceName", resourceName)
                .queryParam("shopCode", shopCode).build().toString();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(api,String.class);
        return restTemplate.getForObject(api,String.class);
    }
}
