package com.service.inventorycatalogue.mapper;

import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;
import com.service.inventorycatalogue.entity.InventoryEntity;

public class UpdateQuantityAFOrderMapper {

    public static UpdateQuantityAFOrderDto mapToUpdateQuantityAFOrderDto(InventoryEntity inventoryEntity, UpdateQuantityAFOrderDto updateQuantityAFOrderDto){
        updateQuantityAFOrderDto.setSku(inventoryEntity.getSku());
        updateQuantityAFOrderDto.setQuantity(inventoryEntity.getQuantity());
        return updateQuantityAFOrderDto;
    }

    public static InventoryEntity mapToInventoryEntity(UpdateQuantityAFOrderDto updateQuantityAFOrderDto, InventoryEntity inventoryEntity){
        inventoryEntity.setSku(updateQuantityAFOrderDto.getSku());
        inventoryEntity.setQuantity(updateQuantityAFOrderDto.getQuantity());
        return inventoryEntity;
    }
}
