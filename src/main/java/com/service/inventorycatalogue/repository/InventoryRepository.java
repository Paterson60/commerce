package com.service.inventorycatalogue.repository;

/**
 * Repository layer helps in performing CRUD operation
 *
 */

import com.service.inventorycatalogue.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {
    Optional<InventoryEntity> findBySku(String sku);
}
