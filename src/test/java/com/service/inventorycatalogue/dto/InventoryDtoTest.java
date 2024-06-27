package com.service.inventorycatalogue.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InventoryDtoTest {
    InventoryDto inventoryDto = new InventoryDto();

    @Test
    void testSetSku() {
        inventoryDto.setSku("sku");
    }

    @Test
    void testSetQuantity() {
        inventoryDto.setQuantity(0);
    }

    @Test
    void testSetCategory() {
        inventoryDto.setCategory("category");
    }

    @Test
    void testSetStatus() {
        inventoryDto.setStatus("status");
    }
}
