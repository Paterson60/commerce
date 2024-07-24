package com.service.productcatalogue.service;

import com.service.productcatalogue.dto.ProductInventoryDto;

/**
 * Service interface layer for getting all the details of inventory and product
 *
 */
public interface IProductInventoryService   {


    ProductInventoryDto fetchProductInventoryDetails(String sku);
}
