package com.service.inventorycatalogue.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SkuExistsExceptionTest {

    @Test
    public void test_exception_thrown_with_correct_message() {

        String expectedMessage = "Product already exists";

        SkuExistsException exception = new SkuExistsException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void test_exception_thrown_with_empty_message() {

        String expectedMessage = "";

        SkuExistsException exception = new SkuExistsException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }
}