package com.service.inventorycatalogue.service;

import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;

public interface IInventoryService {

    void addQuantity(InventoryDto inventoryDto);

    /**
     *
     * @param sku - Input sku
     */
    InventoryDto fetchQuantity(String sku);

    boolean updateQuantity(InventoryDto inventoryDto);

    boolean deleteQuantity(String sku);

    /**
     *
     * @param quantity
     * @return
     */
    boolean reduceStock(UpdateQuantityAFOrderDto updateQuantityAFOrderDto, int quantity);
}
