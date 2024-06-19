package com.service.inventorycatalogue.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateQuantityAFOrderDto {

    @NotEmpty(message = "Sku cannot be null")
    private String sku;

    @Min(1)
    @Max(100)
    @Positive
    private int quantity;
}
