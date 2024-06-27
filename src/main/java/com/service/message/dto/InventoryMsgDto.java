package com.service.message.dto;

/**
 *
 * @param quantity
 * @param sku
 * @param category
 * Helps in sending the message to Inventory Catalogue
 */
public record InventoryMsgDto(String sku, int quantity, String category) {
}
