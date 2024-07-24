package com.service.productcatalogue.repository;

/**
 * ProductAssociation Repository layer helps interacts with productassociation table performing CRUD operation
 *
 */

import com.service.productcatalogue.entity.ProductAssociation;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductAssociationRepository extends JpaRepository<ProductAssociation,Long> {

    Optional<ProductAssociation> findBySku(String sku);
    @Transactional
    @Modifying
    void deleteById(@NotNull Long associationId);

}
