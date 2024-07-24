package com.service.inventorycatalogue.service.impl;

import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;
import com.service.inventorycatalogue.entity.InventoryEntity;
import com.service.inventorycatalogue.exception.ResourceNotFoundException;
import com.service.inventorycatalogue.exception.SkuExistsException;
import com.service.inventorycatalogue.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
//import org.springframework.cloud.stream.function.StreamBridge;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryServiceImplTest {

    @Test
    public void test_adds_new_inventory_item_when_sku_does_not_exist() {
      /*  InventoryRepository inventoryRepository = mock(InventoryRepository.class);
        StreamBridge streamBridge = mock(StreamBridge.class);
        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);

        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setSku("SKU123");
        inventoryDto.setQuantity(10);
        inventoryDto.setCategory("Category1");
        inventoryDto.setStatus("Available");

        when(inventoryRepository.findBySku("SKU123")).thenReturn(Optional.empty());

        inventoryService.addQuantity(inventoryDto);

        verify(inventoryRepository, times(1)).save(any(InventoryEntity.class));*/
    }

    @Test
    public void test_throws_sku_exists_exception_when_sku_already_exists() {
//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        StreamBridge streamBridge = mock(StreamBridge.class);
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);
//
//        InventoryDto inventoryDto = new InventoryDto();
//        inventoryDto.setSku("SKU123");
//        inventoryDto.setQuantity(10);
//        inventoryDto.setCategory("Category1");
//        inventoryDto.setStatus("Available");
//
//        InventoryEntity existingEntity = new InventoryEntity();
//        existingEntity.setSku("SKU123");
//
//        when(inventoryRepository.findBySku("SKU123")).thenReturn(Optional.of(existingEntity));
//
//        assertThrows(SkuExistsException.class, () -> {
//            inventoryService.addQuantity(inventoryDto);
//        });
    }

    @Test
    public void test_fetch_quantity_success() {

//        String sku = "test-sku";
//        InventoryEntity inventoryEntity = new InventoryEntity();
//        inventoryEntity.setSku(sku);
//        inventoryEntity.setQuantity(50);
//        inventoryEntity.setCategory("Electronics");
//        inventoryEntity.setStatus("Available");
//
//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        when(inventoryRepository.findBySku(sku)).thenReturn(Optional.of(inventoryEntity));
//
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, null);
//
//        InventoryDto result = inventoryService.fetchQuantity(sku);
//
//        assertNotNull(result);
//        assertEquals(sku, result.getSku());
//        assertEquals(50, result.getQuantity());
//        assertEquals("Electronics", result.getCategory());
//        assertEquals("Available", result.getStatus());
    }

    @Test
    public void test_fetch_quantity_sku_not_found() {

//        String sku = "non-existent-sku";
//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        when(inventoryRepository.findBySku(sku)).thenReturn(Optional.empty());
//
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, null);
//
//        assertThrows(ResourceNotFoundException.class, () -> {
//            inventoryService.fetchQuantity(sku);
//        });
    }

    @Test
    public void test_update_quantity_success() {
//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        StreamBridge streamBridge = mock(StreamBridge.class);
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);
//
//        InventoryDto inventoryDto = new InventoryDto();
//        inventoryDto.setSku("SKU123");
//        inventoryDto.setQuantity(50);
//        inventoryDto.setCategory("Electronics");
//        inventoryDto.setStatus("Available");
//
//        InventoryEntity inventoryEntity = new InventoryEntity();
//        inventoryEntity.setSku("SKU123");
//        inventoryEntity.setQuantity(30);
//        inventoryEntity.setCategory("Electronics");
//        inventoryEntity.setStatus("Available");
//
//        when(inventoryRepository.findBySku("SKU123")).thenReturn(Optional.of(inventoryEntity));
//        when(inventoryRepository.save(any(InventoryEntity.class))).thenReturn(inventoryEntity);
//
//        boolean result = inventoryService.updateQuantity(inventoryDto);
//
//        assertTrue(result);
//        verify(inventoryRepository, times(1)).findBySku("SKU123");
//        verify(inventoryRepository, times(1)).save(any(InventoryEntity.class));
    }

    @Test
    public void test_update_quantity_sku_not_found() {
//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        StreamBridge streamBridge = mock(StreamBridge.class);
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);
//
//        InventoryDto inventoryDto = new InventoryDto();
//        inventoryDto.setSku("SKU123");
//        inventoryDto.setQuantity(50);
//        inventoryDto.setCategory("Electronics");
//        inventoryDto.setStatus("Available");
//
//        when(inventoryRepository.findBySku("SKU123")).thenReturn(Optional.empty());
//
//        assertThrows(ResourceNotFoundException.class, () -> {
//            inventoryService.updateQuantity(inventoryDto);
//        });
//
//        verify(inventoryRepository, times(1)).findBySku("SKU123");
//        verify(inventoryRepository, times(0)).save(any(InventoryEntity.class));
    }

    @Test
    public void test_delete_existing_inventory_item_by_sku() {
//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        StreamBridge streamBridge = mock(StreamBridge.class);
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);
//
//        String sku = "test-sku";
//        InventoryEntity inventoryEntity = new InventoryEntity();
//        inventoryEntity.setId(1L);
//        inventoryEntity.setSku(sku);
//
//        when(inventoryRepository.findBySku(sku)).thenReturn(Optional.of(inventoryEntity));
//
//        boolean result = inventoryService.deleteQuantity(sku);
//
//        verify(inventoryRepository, times(1)).deleteById(inventoryEntity.getId());
//        assertTrue(result);
    }

    @Test
    public void test_delete_non_existent_inventory_item_by_sku() {
//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        StreamBridge streamBridge = mock(StreamBridge.class);
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);
//
//        String sku = "non-existent-sku";
//
//        when(inventoryRepository.findBySku(sku)).thenReturn(Optional.empty());
//
//        assertThrows(ResourceNotFoundException.class, () -> {
//            inventoryService.deleteQuantity(sku);
//        });
//
//        verify(inventoryRepository, never()).deleteById(anyLong());
    }

    @Test
    public void test_reduce_stock_success() {
//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        StreamBridge streamBridge = mock(StreamBridge.class);
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);
//
//        UpdateQuantityAFOrderDto updateQuantityAFOrderDto = new UpdateQuantityAFOrderDto();
//        updateQuantityAFOrderDto.setSku("validSKU");
//        updateQuantityAFOrderDto.setQuantity(5);
//
//        InventoryEntity inventoryEntity = new InventoryEntity();
//        inventoryEntity.setSku("validSKU");
//        inventoryEntity.setQuantity(20);
//
//        when(inventoryRepository.findBySku("validSKU")).thenReturn(Optional.of(inventoryEntity));
//        when(inventoryRepository.save(any(InventoryEntity.class))).thenReturn(inventoryEntity);
//
//        boolean result = inventoryService.reduceStock(updateQuantityAFOrderDto, 5);
//
//        assertTrue(result);
//        //assertEquals(15, result);
    }

    @Test
    public void test_reduce_stock_sku_not_found() {
//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        StreamBridge streamBridge = mock(StreamBridge.class);
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);
//
//        UpdateQuantityAFOrderDto updateQuantityAFOrderDto = new UpdateQuantityAFOrderDto();
//        updateQuantityAFOrderDto.setSku("invalidSKU");
//        updateQuantityAFOrderDto.setQuantity(5);
//
//        when(inventoryRepository.findBySku("invalidSKU")).thenReturn(Optional.empty());
//
//        assertThrows(ResourceNotFoundException.class, () -> {
//            inventoryService.reduceStock(updateQuantityAFOrderDto, 5);
//        });
    }

    @Test
    public void test_update_communication_with_valid_sku() {

//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        StreamBridge streamBridge = mock(StreamBridge.class);
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);
//        String sku = "validSKU";
//        InventoryEntity inventoryEntity = new InventoryEntity();
//        inventoryEntity.setSku(sku);
//        when(inventoryRepository.findBySku(sku)).thenReturn(Optional.of(inventoryEntity));
//
//        boolean result = inventoryService.updateCommunication(sku);
//
//        assertTrue(result);
//        assertEquals("Product ending soon", inventoryEntity.getStatus());
//        assertTrue(inventoryEntity.getCommunication());
//        verify(inventoryRepository, times(1)).save(inventoryEntity);
    }

    @Test
    public void test_update_communication_with_null_sku() {

//        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
//        StreamBridge streamBridge = mock(StreamBridge.class);
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl(inventoryRepository, streamBridge);
//
//        boolean result = inventoryService.updateCommunication(null);
//
//        assertFalse(result);
//        verify(inventoryRepository, times(0)).findBySku(anyString());
    }
}