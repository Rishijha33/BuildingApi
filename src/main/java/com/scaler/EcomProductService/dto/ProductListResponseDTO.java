package com.scaler.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductListResponseDTO {
    List<ProductResponseDto> products;
}
