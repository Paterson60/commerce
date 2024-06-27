package com.service.inventorycatalogue.dto;

/**
 * Dto layer to update quantity number
 *
 */

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(
        name = "After Order Quantity update",
        description = "Schema to hold quantity details after order "
)
public class UpdateQuantityAFOrderDto {

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
}
