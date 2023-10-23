package com.scaler.EcomProductService.controller;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDto;
import com.scaler.EcomProductService.dto.ProductResponseDto;
import com.scaler.EcomProductService.model.Product;
import com.scaler.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

//    @Autowired
//    @Qualifier("fakeStoreProductService")
//    private ProductService productService;
//    private RestTemplateBuilder restTemplateBuilder;

    private ProductService productService;
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired //Constructor injection
    public ProductController(RestTemplateBuilder restTemplateBuilder,@Qualifier("fakeStoreProductService") ProductService productService)
    {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productService = productService;
    }



    @GetMapping("/product") //Get all the products
    public ResponseEntity getAllProducts()
    {
        List<ProductResponseDto> responseDtos = productService.getAllProducts();
        return ResponseEntity.ok(responseDtos);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDto productRequestDto)
    {
        ProductResponseDto responseDto = productService.createProduct(productRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id)
    {
        ProductResponseDto productResponseDto = productService.getProductById(id);
        return ResponseEntity.ok(productResponseDto);
    }


}
