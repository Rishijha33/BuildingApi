package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductRequestClientDTO;
import com.scaler.EcomProductService.dto.ProductRequestDto;
import com.scaler.EcomProductService.dto.ProductResponseClientDTO;
import com.scaler.EcomProductService.dto.ProductResponseDto;
import com.scaler.EcomProductService.mapper.ProductMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import static com.scaler.EcomProductService.mapper.ProductMapper.clientResponseDtoToResponseDto;
import static com.scaler.EcomProductService.mapper.ProductMapper.requestDtoToClientRequestDto;
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;


    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder,
                                   FakeStoreProductServiceClient fakeStoreProductServiceClient)
    {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;

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
        ProductResponseClientDTO productById= fakeStoreProductServiceClient.getProductById(id);
        return clientResponseDtoToResponseDto(productById);


    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        ProductRequestClientDTO productRequestClientDTO = requestDtoToClientRequestDto(productRequestDto);
        ProductResponseClientDTO productResponseClientDTO = fakeStoreProductServiceClient.createProduct(productRequestClientDTO);
        return clientResponseDtoToResponseDto(productResponseClientDTO);
    }


}
