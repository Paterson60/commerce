package com.service.inventorycatalogue.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

class InventoryEntityTest {
    InventoryEntity inventoryEntity = new InventoryEntity(Long.valueOf(1), "sku", 0, "category", "status", Boolean.TRUE, LocalDateTime.of(2024, Month.JUNE, 26, 19, 43, 12), LocalDateTime.of(2024, Month.JUNE, 26, 19, 43, 12));

    @Test
    void testSetId() {
        inventoryEntity.setId(Long.valueOf(1));
    }

    @Test
    void testSetSku() {
        inventoryEntity.setSku("sku");
    }

    @Test
    void testSetQuantity() {
        inventoryEntity.setQuantity(0);
    }

    @Test
    void testSetCategory() {
        inventoryEntity.setCategory("category");
    }

    @Test
    void testSetStatus() {
        inventoryEntity.setStatus("status");
    }

    @Test
    void testSetCommunication() {
        inventoryEntity.setCommunication(Boolean.TRUE);
    }

    @Test
    void testSetCreatedAt() {
        inventoryEntity.setCreatedAt(LocalDateTime.of(2024, Month.JUNE, 26, 19, 43, 12));
    }

    @Test
    void testSetUpdatedAt() {
        inventoryEntity.setUpdatedAt(LocalDateTime.of(2024, Month.JUNE, 26, 19, 43, 12));
    }

    @Test
    void testToString() {
        String result = inventoryEntity.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", "replaceMeWithExpectedResult");
    }
}
