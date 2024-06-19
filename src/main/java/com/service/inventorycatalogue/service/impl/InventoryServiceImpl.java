package com.service.inventorycatalogue.service.impl;

import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;
import com.service.inventorycatalogue.entity.InventoryEntity;
import com.service.inventorycatalogue.exception.ResourceNotFoundException;
import com.service.inventorycatalogue.exception.SkuExistsException;
import com.service.inventorycatalogue.mapper.InventoryMapper;
import com.service.inventorycatalogue.mapper.UpdateQuantityAFOrderMapper;
import com.service.inventorycatalogue.repository.InventoryRepository;
import com.service.inventorycatalogue.service.IInventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements IInventoryService {

    private InventoryRepository inventoryRepository;


    /**
     * @param inventoryDto
     */
    @Override
    public void addQuantity(InventoryDto inventoryDto) {
        InventoryEntity inventoryEntity = InventoryMapper.mapToInventoryEntity(inventoryDto, new InventoryEntity());
        Optional<InventoryEntity> bySku = inventoryRepository.findBySku(inventoryDto.getSku());
        if (bySku.isPresent()){
            throw new SkuExistsException("Sku Already exists" + inventoryDto.getSku());
        }
        inventoryRepository.save(inventoryEntity);

    }

    /**
     * @param sku - Input sku
     * @return
     */
    @Override
    public InventoryDto fetchQuantity(String sku) {
        InventoryEntity inventory = inventoryRepository.findBySku(sku).orElseThrow(
                ()-> new ResourceNotFoundException("Inventory","Sku", sku)
        );
        return InventoryMapper.mapToInventoryDto(inventory, new InventoryDto());
    }

    /**
     * @param inventoryDto
     * @return
     */
    @Override
    public boolean updateQuantity(InventoryDto inventoryDto) {
        boolean isUpdated = false;
        if(inventoryDto != null){
            InventoryEntity inventoryEntity = inventoryRepository.findBySku(inventoryDto.getSku()).orElseThrow(
                    () -> new ResourceNotFoundException("Inventory","Sku",inventoryDto.getSku())
            );
            InventoryMapper.mapToInventoryEntity(inventoryDto, inventoryEntity);
            inventoryRepository.save(inventoryEntity);
            isUpdated = true;
        }

        return isUpdated;
    }

    /**
     * @param sku
     * @return
     */
    @Override
    public boolean deleteQuantity(String sku) {
        InventoryEntity inventoryEntity = inventoryRepository.findBySku(sku).orElseThrow(
                () -> new ResourceNotFoundException("Inventory","Sku", sku)
        );
        inventoryRepository.deleteById(inventoryEntity.getId());
        return true;
    }

    /**
     * @param updateQuantityAFOrderDto
     * @return true
     */
    @Override
    public boolean reduceStock(UpdateQuantityAFOrderDto updateQuantityAFOrderDto, int quantity) {
        boolean isOrdered = false;
        if(updateQuantityAFOrderDto != null) {
            InventoryEntity inventoryEntity = inventoryRepository.findBySku(updateQuantityAFOrderDto.getSku()).orElseThrow(
                    () -> new ResourceNotFoundException("Inventory","Sku",updateQuantityAFOrderDto.getSku())
            );
            UpdateQuantityAFOrderMapper.mapToInventoryEntity(updateQuantityAFOrderDto, inventoryEntity);
            int newQuantity = inventoryEntity.getQuantity() - quantity;
            inventoryEntity.setQuantity(newQuantity);
            inventoryRepository.save(inventoryEntity);
            isOrdered = true;
        }
        return isOrdered;
    }


}
