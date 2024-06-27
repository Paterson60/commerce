package com.service.inventorycatalogue.dto;

/**
 * Dto layer of InventoryEntity
 *
 */

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(
        name = "Inventory",
        description = "Schema to hold Inventory details"
)
public class InventoryDto {

    @Schema(
            description = "Unique representation of the Inventory", example = "AZVP1!"
    )
    @NotEmpty(message = "Sku cannot be null")
    private String sku;

    @Schema(
            description = "Quantity of the Product", example = "20"
    )
    @Min(1)
    @Max(100)
    @Positive
    private int quantity;

    @Schema(
            description = "Category representation of the Inventory", example = "Mobile!"
    )
    @NotEmpty(message = "Category cannot be empty")
    private String category;

    @Schema(
            description = "Status representation of the Inventory"
    )
    @NotEmpty(message = "Status cannot be empty")
    private String status;
}
