package com.service.inventorycatalogue.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class InventoryDto {

    @NotEmpty(message = "Sku cannot be null")
    private String sku;

    @Min(1)
    @Max(100)
    @Positive
    private int quantity;

    @NotEmpty(message = "Category cannot be empty")
    private String category;

    @NotEmpty(message = "Status cannot be empty")
    private String status;
}
