package com.service.productcatalogue.service.impl;

/**
 * Service implementation layer helps in fetching all the details from product and inventory catalogue
 *
 */

import com.service.productcatalogue.dto.InventoryDto;
import com.service.productcatalogue.dto.ProductAssociationDto;
import com.service.productcatalogue.dto.ProductInventoryDto;
import com.service.productcatalogue.entity.Price;
import com.service.productcatalogue.entity.Product;
import com.service.productcatalogue.entity.ProductAssociation;
import com.service.productcatalogue.exception.ResourceNotFoundException;
import com.service.productcatalogue.mapper.AllProductMapperProductMapper;
import com.service.productcatalogue.mapper.ProductAssociationMapper;
import com.service.productcatalogue.mapper.ProductMapper;
import com.service.productcatalogue.repository.PriceRepository;
import com.service.productcatalogue.repository.ProductAssociationRepository;
import com.service.productcatalogue.repository.ProductRepository;
import com.service.productcatalogue.service.IProductInventoryService;
//import com.service.productcatalogue.service.client.InventoryFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductInventoryServiceImpl implements IProductInventoryService {

    private ProductRepository productRepository;
    private ProductAssociationRepository productAssociationRepository;
    private PriceRepository priceRepository;
    //private InventoryFeignClient inventoryFeignClient;


    /**
     * @param sku
     * @return
     */
    @Override
    public ProductInventoryDto fetchProductInventoryDetails(String sku) {
//        Product product = productRepository.findBySku(sku).orElseThrow(
//               ()-> new ResourceNotFoundException("Product","Sku", sku)
//       );
//       ProductAssociation productAssociation = productAssociationRepository.findBySku(product.getSku()).orElseThrow(
//               ()-> new ResourceNotFoundException("RelatedProduct","Sku", sku)
//       );
//
//       ProductInventoryDto productInventoryDto = AllProductMapperProductMapper.mapToProductInventoryDetailsDto(product, new ProductInventoryDto());
//       productInventoryDto.setProductAssociationDto(ProductAssociationMapper.mapToProductAssociationDto(productAssociation, new ProductAssociationDto()));
//
//       Price price = priceRepository.findByPriceId(product.getProductId());
//       productInventoryDto.setPriceDto(ProductMapper.mapToPriceDto(price));
//
//       ResponseEntity<InventoryDto> inventoryDtoResponseEntity = inventoryFeignClient.fetchQuantity(sku);
//       productInventoryDto.setInventoryDto(inventoryDtoResponseEntity.getBody());
//
//       return productInventoryDto;
			return null;
    }
}
