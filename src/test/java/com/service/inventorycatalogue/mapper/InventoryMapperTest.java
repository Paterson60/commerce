package com.service.inventorycatalogue.mapper;

import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.entity.InventoryEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InventoryMapperTest {

    @Test
    public void test_correctly_maps_all_fields() {
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setSku("SKU123");
        inventoryEntity.setQuantity(50);
        inventoryEntity.setCategory("Electronics");
        inventoryEntity.setStatus("Available");

        InventoryDto inventoryDto = new InventoryDto();

        InventoryMapper.mapToInventoryDto(inventoryEntity, inventoryDto);

        assertEquals("SKU123", inventoryDto.getSku());
        assertEquals(50, inventoryDto.getQuantity());
        assertEquals("Electronics", inventoryDto.getCategory());
        assertEquals("Available", inventoryDto.getStatus());
    }

    @Test
    public void test_handles_null_fields_gracefully() {
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setSku(null);
        inventoryEntity.setQuantity(0);
        inventoryEntity.setCategory(null);
        inventoryEntity.setStatus(null);

        InventoryDto inventoryDto = new InventoryDto();

        InventoryMapper.mapToInventoryDto(inventoryEntity, inventoryDto);

        assertNull(inventoryDto.getSku());
        assertEquals(0, inventoryDto.getQuantity());
        assertNull(inventoryDto.getCategory());
        assertNull(inventoryDto.getStatus());
    }
}
