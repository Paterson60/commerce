package com.service.inventorycatalogue.mapper;

import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;
import com.service.inventorycatalogue.entity.InventoryEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateQuantityAFOrderMapperTest {

    @Test
    public void test_maps_sku_correctly() {
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setSku("test-sku");
        inventoryEntity.setQuantity(10);

        UpdateQuantityAFOrderDto updateQuantityAFOrderDto = new UpdateQuantityAFOrderDto();

        UpdateQuantityAFOrderDto result = UpdateQuantityAFOrderMapper.mapToUpdateQuantityAFOrderDto(inventoryEntity, updateQuantityAFOrderDto);

        assertEquals("test-sku", result.getSku());
        assertEquals(10, result.getQuantity());
    }

    @Test
    public void test_inventory_entity_with_null_sku() {
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setSku(null);
        inventoryEntity.setQuantity(10);

        UpdateQuantityAFOrderDto updateQuantityAFOrderDto = new UpdateQuantityAFOrderDto();

        UpdateQuantityAFOrderDto result = UpdateQuantityAFOrderMapper.mapToUpdateQuantityAFOrderDto(inventoryEntity, updateQuantityAFOrderDto);

        assertNull(result.getSku());
        assertEquals(10, result.getQuantity());
    }

    @Test
    public void test_update_quantity_af_order_dto_with_null_sku() {
        UpdateQuantityAFOrderDto updateQuantityAFOrderDto = new UpdateQuantityAFOrderDto();
        updateQuantityAFOrderDto.setSku(null);
        updateQuantityAFOrderDto.setQuantity(10);

        InventoryEntity inventoryEntity = new InventoryEntity();

        InventoryEntity result = UpdateQuantityAFOrderMapper.mapToInventoryEntity(updateQuantityAFOrderDto, inventoryEntity);

        assertNull(result.getSku());
        assertEquals(10, result.getQuantity());
    }

}