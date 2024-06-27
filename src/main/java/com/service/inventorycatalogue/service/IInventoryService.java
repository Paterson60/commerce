package com.service.inventorycatalogue.service;

/**
 * IInventoryService layer is an interface helps in implementation of/
 * performing CRUD operation and other business logic like sending communication
 *
 */

import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;

public interface IInventoryService {

    /**
     *Helps in adding the Quantity of the prodct
     * @param inventoryDto - Input sku
     */
    void addQuantity(InventoryDto inventoryDto);

    /**
     *Helps to get the details of the quantity
     * @param sku - Input sku
     */
    InventoryDto fetchQuantity(String sku);

    /**
     *Helps in updating the inventory details
     * @param inventoryDto - Input sku
     */
    boolean updateQuantity(InventoryDto inventoryDto);

    /**
     *Helps in deleting the inventory details
     * @param sku - Input sku
     */
    boolean deleteQuantity(String sku);

    /**
     *Helps in reducing the quantity number
     * @param quantity
     * @return
     */
    boolean reduceStock(UpdateQuantityAFOrderDto updateQuantityAFOrderDto, int quantity);

    boolean updateCommunication(String sku);
}
