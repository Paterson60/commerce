package com.service.inventorycatalogue.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @param quantity
 * @param sku
 * @param category
 * Dto layer for receiving the message for message artifact
 */

@Schema(
        name = "InventoryMsdDto",
        description = "Schema to hold Inventory message details"
)
public record InventoryMsgDto(String sku, int quantity, String category) {
}
