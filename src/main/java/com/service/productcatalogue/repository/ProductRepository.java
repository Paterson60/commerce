package com.service.productcatalogue.repository;

/**
 * Price Repository layer helps interacts with product table performing CRUD operation
 *
 */

import com.service.productcatalogue.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    Optional<Product> findBySku(String sku);
}
