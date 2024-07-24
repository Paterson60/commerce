package com.service.productcatalogue.mapper;

/**
 * Converts the AddAllProductDetailsDto Dto layer to Product Entity layer and vice versa
 *
 */

import com.service.productcatalogue.dto.AddAllProductDetailsDto;
import com.service.productcatalogue.dto.ProductInventoryDto;
import com.service.productcatalogue.entity.Product;

public class AllProductMapperProductMapper {

    public static AddAllProductDetailsDto mapToAllProductDto(Product product, AddAllProductDetailsDto addAllProductDetailsDto){
        addAllProductDetailsDto.setName(product.getName());
        addAllProductDetailsDto.setCategory(product.getCategory());
        addAllProductDetailsDto.setDescription(product.getDescription());
        addAllProductDetailsDto.setImage(product.getImage());
        addAllProductDetailsDto.setSpecification(product.getSpecification());
        addAllProductDetailsDto.setSku(product.getSku());
        addAllProductDetailsDto.setBrand(product.getBrand());
        return addAllProductDetailsDto;
    }

    public static Product mapToProduct(AddAllProductDetailsDto addAllProductDetailsDto, Product product){
        product.setName(addAllProductDetailsDto.getName());
        product.setCategory(addAllProductDetailsDto.getCategory());
        product.setDescription(addAllProductDetailsDto.getDescription());
        product.setImage(addAllProductDetailsDto.getImage());
        product.setSpecification(addAllProductDetailsDto.getSpecification());
        product.setSku(addAllProductDetailsDto.getSku());
        product.setBrand(addAllProductDetailsDto.getBrand());
        return product;
    }

    public static ProductInventoryDto mapToProductInventoryDetailsDto(Product product, ProductInventoryDto productInventoryDto){
        productInventoryDto.setName(product.getName());
        productInventoryDto.setCategory(product.getCategory());
        productInventoryDto.setDescription(product.getDescription());
        productInventoryDto.setImage(product.getImage());
        productInventoryDto.setSpecification(product.getSpecification());
        productInventoryDto.setSku(product.getSku());
        productInventoryDto.setBrand(product.getBrand());
        return productInventoryDto;
    }
}
