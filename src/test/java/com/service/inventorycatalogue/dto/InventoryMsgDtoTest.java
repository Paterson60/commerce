package com.service.inventorycatalogue.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InventoryMsgDtoTest {
    InventoryMsgDto inventoryMsgDto = new InventoryMsgDto("sku", 0, "category");


    @Test
    void testQuantity() {
        int result = inventoryMsgDto.quantity();
        Assertions.assertEquals(0, result);
    }

}

