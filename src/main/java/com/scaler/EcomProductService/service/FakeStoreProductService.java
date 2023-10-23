package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductRequestDto;
import com.scaler.EcomProductService.dto.ProductResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List getAllProducts() {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate =  restTemplateBuilder.build();
        ResponseEntity<List> productResponse =
                restTemplate.getForEntity(getAllProductsURL,List.class);

        return productResponse.getBody();
    }

    @Override
    public ProductResponseDto getProductById(int id) {
        String getProductByIdURL = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDto> productResponse = restTemplate.getForEntity(getProductByIdURL, ProductResponseDto.class);
        return productResponse.getBody();
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        String createProductURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDto> productResponse = restTemplate.postForEntity(createProductURL, productRequestDto, ProductResponseDto.class);
        return productResponse.getBody();
    }


}
