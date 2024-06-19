package com.service.inventorycatalogue.mapper;

import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.entity.InventoryEntity;

public class InventoryMapper {

    public static InventoryDto mapToInventoryDto(InventoryEntity inventoryEntity, InventoryDto inventoryDto){
        inventoryDto.setSku(inventoryEntity.getSku());
        inventoryDto.setQuantity(inventoryEntity.getQuantity());
        inventoryDto.setCategory(inventoryEntity.getCategory());
        inventoryDto.setStatus(inventoryEntity.getStatus());
        return inventoryDto;
    }

    public static InventoryEntity mapToInventoryEntity(InventoryDto inventoryDto, InventoryEntity inventoryEntity){
        inventoryEntity.setSku(inventoryDto.getSku());
        inventoryEntity.setQuantity(inventoryDto.getQuantity());
        inventoryEntity.setCategory(inventoryDto.getCategory());
        inventoryEntity.setStatus(inventoryDto.getStatus());
        return inventoryEntity;
    }
}
