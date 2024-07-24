package com.service.productcatalogue.service;

/**
 * IProductService layer is an interface helps in implementation of/
 * performing CRUD operation and other business logic like searching product and so on
 *
 */

import com.service.productcatalogue.dto.AddAllProductDetailsDto;
import com.service.productcatalogue.dto.PriceDto;
import com.service.productcatalogue.dto.ProductDto;
import com.service.productcatalogue.dto.ProductSearchCriteriaDto;
import com.service.productcatalogue.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {

    /**
     *
     * @param addAllProductDetailsDto - AddAllProductDetailsDto Object
     * helps in adding a new product
     */
    void addProduct(AddAllProductDetailsDto addAllProductDetailsDto);

    /**
     * @param sku - Input sku
     * fetch a product based on the sku
     */
    ProductDto fetchProduct(String sku);

    /**
     *
     * It will fetch all products
     */

    List<Product> fetchAllProducts();

    /**
     *
     * @param productDto - Input productDto
     * helps in updating the product details except sku (sku is a unique for each product)
     */
    boolean updateProduct(ProductDto productDto);

    /**
     *
     * @param sku - Input sku
     * helps in deleting the product based upon the sku
     */
    boolean deleteProduct(String sku);

    /**
     * @param searchCriteria - Input searchDto
     *                       helps in searching a product based upon on the sku, category, name etc..
     */
    List<ProductDto> searchProducts(ProductSearchCriteriaDto searchCriteria);

    /**
     *
     * @param pageNumber,pageSize,sortProperty - Input pageNumber,pageSize,sortProperty
     * helps in get product details by page number, page size
     */
    Page<Product> getProductPagination(Integer pageNumber, Integer pageSize, String sortProperty);

    /**
     * Fetches the price details by price ID and helps in update price of a product
     *
     * @param productId
     * @param priceDto
     * @return the PriceDto object containing price details
     */
    void updatePrice(Long productId, PriceDto priceDto);

}
