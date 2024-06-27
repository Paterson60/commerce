package com.service.inventorycatalogue.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpContactInfoDtoTest {

    @Test
    public void test_setting_and_getting_message_property() {
        HelpContactInfoDto dto = new HelpContactInfoDto();
        String expectedMessage = "Support is available 24/7";
        dto.setMessage(expectedMessage);
        assertEquals(expectedMessage, dto.getMessage());
    }
}