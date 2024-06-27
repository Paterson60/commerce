package com.service.inventorycatalogue.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UpdateQuantityAFOrderDtoTest {
    UpdateQuantityAFOrderDto updateQuantityAFOrderDto = new UpdateQuantityAFOrderDto();

    @Test
    void testSetSku() {
        updateQuantityAFOrderDto.setSku("sku");
    }

    @Test
    void testSetQuantity() {
        updateQuantityAFOrderDto.setQuantity(0);
    }

    @Test
    public void test_valid_sku_and_quantity_within_range() {
        UpdateQuantityAFOrderDto dto = new UpdateQuantityAFOrderDto();
        dto.setSku("validSKU");
        dto.setQuantity(10);

        Set<ConstraintViolation<UpdateQuantityAFOrderDto>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(dto);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void test_empty_sku_should_fail_validation() {
        UpdateQuantityAFOrderDto dto = new UpdateQuantityAFOrderDto();
        dto.setSku("");
        dto.setQuantity(10);

        Set<ConstraintViolation<UpdateQuantityAFOrderDto>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(dto);

        assertFalse(violations.isEmpty());
        assertEquals("Sku cannot be null", violations.iterator().next().getMessage());
    }
}