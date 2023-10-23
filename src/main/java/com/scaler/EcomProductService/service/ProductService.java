package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDto;
import com.scaler.EcomProductService.dto.ProductResponseDto;
import com.scaler.EcomProductService.model.Product;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(int id);

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

}
