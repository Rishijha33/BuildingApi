package com.scaler.EcomProductService.mapper;

import com.scaler.EcomProductService.dto.ProductRequestClientDTO;
import com.scaler.EcomProductService.dto.ProductRequestDto;
import com.scaler.EcomProductService.dto.ProductResponseClientDTO;
import com.scaler.EcomProductService.dto.ProductResponseDto;

public class ProductMapper {


    public static ProductResponseDto clientResponseDtoToResponseDto(ProductResponseClientDTO productResponseClientDTO)
    {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(productResponseClientDTO.getId());
        productResponseDto.setTitle(productResponseClientDTO.getTitle());
        productResponseDto.setCategory(productResponseClientDTO.getCategory());
        productResponseDto.setPrice(productResponseClientDTO.getPrice());
        productResponseDto.setImage(productResponseClientDTO.getImage());
        productResponseDto.setDescription(productResponseClientDTO.getDescription());

        return productResponseDto;
    }

    public static ProductRequestClientDTO requestDtoToClientRequestDto(ProductRequestDto productRequestDto)
    {
        ProductRequestClientDTO productRequestClientDTO = new ProductRequestClientDTO();
        productRequestClientDTO.setTitle(productRequestDto.getTitle());
        productRequestClientDTO.setCategory(productRequestDto.getCategory());
        productRequestClientDTO.setPrice(productRequestDto.getPrice());
        productRequestClientDTO.setImage(productRequestDto.getImage());
        productRequestClientDTO.setDescription(productRequestDto.getDescription());
        return productRequestClientDTO;
    }
}
