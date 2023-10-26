package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductRequestClientDTO;
import com.scaler.EcomProductService.dto.ProductResponseClientDTO;
import com.scaler.EcomProductService.dto.ProductResponseDto;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreProductServiceClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceClient (RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    ProductResponseClientDTO getProductById(int id)
    {
        String getProductByIdURL = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseClientDTO> productResponse = restTemplate.getForEntity(getProductByIdURL, ProductResponseClientDTO.class);
        return productResponse.getBody();
    }

    ProductResponseClientDTO createProduct(ProductRequestClientDTO productRequestClientDTO)
    {
        String createProductURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseClientDTO> productResponse = restTemplate.postForEntity(createProductURL, productRequestClientDTO, ProductResponseClientDTO.class);
        return productResponse.getBody();
    }
}
