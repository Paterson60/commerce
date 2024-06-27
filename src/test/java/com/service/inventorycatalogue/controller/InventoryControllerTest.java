package com.service.inventorycatalogue.controller;

import com.service.inventorycatalogue.constants.InventoryConstants;
import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.dto.ResponseDto;
import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;
import com.service.inventorycatalogue.service.IInventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class InventoryControllerTest {
    @Mock
    IInventoryService iInventoryService;
    @Mock
    HelpContactInfoDto helpContactInfoDto;
    @InjectMocks
    InventoryController inventoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddQuantitySuccess() {
        IInventoryService inventoryService = Mockito.mock(IInventoryService.class);
        InventoryController inventoryController = new InventoryController(inventoryService);
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setSku("12345");
        inventoryDto.setQuantity(10);
        inventoryDto.setCategory("Electronics");
        inventoryDto.setStatus("Available");

        ResponseEntity<ResponseDto> response = inventoryController.addQuantity(inventoryDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(InventoryConstants.STATUS_201, response.getBody().getStatusCode());
        assertEquals(InventoryConstants.MESSAGE_201, response.getBody().getStatusMsg());
    }

    @Test
    public void testFetchQuantityWithValidSku() {
        IInventoryService iInventoryService = mock(IInventoryService.class);
        InventoryController inventoryController = new InventoryController(iInventoryService);
        InventoryDto expectedInventoryDto = new InventoryDto();
        expectedInventoryDto.setSku("validSku");
        expectedInventoryDto.setQuantity(10);
        expectedInventoryDto.setCategory("category");
        expectedInventoryDto.setStatus("status");

        when(iInventoryService.fetchQuantity("validSku")).thenReturn(expectedInventoryDto);

        ResponseEntity<InventoryDto> response = inventoryController.fetchQuantity("validSku");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedInventoryDto, response.getBody());
    }

    @Test
    public void testUpdateQuantitySuccess() {
        IInventoryService iInventoryService = mock(IInventoryService.class);
        InventoryController inventoryController = new InventoryController(iInventoryService);
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setSku("validSku");
        inventoryDto.setQuantity(10);
        inventoryDto.setCategory("category");
        inventoryDto.setStatus("status");

        when(iInventoryService.updateQuantity(any())).thenReturn(true);

        ResponseEntity<ResponseDto> result = inventoryController.updateQuantity(inventoryDto);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(InventoryConstants.STATUS_200, result.getBody().getStatusCode());
        assertEquals(InventoryConstants.MESSAGE_201, result.getBody().getStatusMsg());
    }

    @Test
    public void testUpdateQuantityFailNullEmptySku() {
        IInventoryService iInventoryService = mock(IInventoryService.class);
        InventoryController inventoryController = new InventoryController(iInventoryService);
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setSku("");
        inventoryDto.setQuantity(10);
        inventoryDto.setCategory("category");
        inventoryDto.setStatus("status");

        when(iInventoryService.updateQuantity(any())).thenReturn(false);

        ResponseEntity<ResponseDto> result = inventoryController.updateQuantity(inventoryDto);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertEquals(InventoryConstants.STATUS_500, result.getBody().getStatusCode());
        assertEquals(InventoryConstants.MESSAGE_500, result.getBody().getStatusMsg());
    }

    @Test
    public void testDeleteQuantitySuccess() {
        IInventoryService iInventoryService = mock(IInventoryService.class);
        InventoryController inventoryController = new InventoryController(iInventoryService);
        when(iInventoryService.deleteQuantity(anyString())).thenReturn(true);

        ResponseEntity<ResponseDto> result = inventoryController.deleteQuantity("sku");
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(InventoryConstants.STATUS_200, result.getBody().getStatusCode());
        assertEquals(InventoryConstants.MESSAGE_200, result.getBody().getStatusMsg());
    }

    @Test
    public void testDeleteQuantityFailure() {
        IInventoryService iInventoryService = mock(IInventoryService.class);
        InventoryController inventoryController = new InventoryController(iInventoryService);
        when(iInventoryService.deleteQuantity(anyString())).thenReturn(false);

        ResponseEntity<ResponseDto> result = inventoryController.deleteQuantity("nonexistent_sku");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertEquals(InventoryConstants.STATUS_417, result.getBody().getStatusCode());
        assertEquals(InventoryConstants.MESSAGE_417_DELETE, result.getBody().getStatusMsg());
    }

    @Test
    public void testPlaceOrderSuccess() {
        IInventoryService iInventoryService = mock(IInventoryService.class);
        InventoryController inventoryController = new InventoryController(iInventoryService);
        UpdateQuantityAFOrderDto updateQuantityAFOrderDto = new UpdateQuantityAFOrderDto();
        updateQuantityAFOrderDto.setSku("validSKU");
        updateQuantityAFOrderDto.setQuantity(10);

        when(iInventoryService.reduceStock(any(UpdateQuantityAFOrderDto.class), anyInt())).thenReturn(true);

        ResponseEntity<ResponseDto> response = inventoryController.placeOrder(updateQuantityAFOrderDto, 10);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(InventoryConstants.STATUS_200, response.getBody().getStatusCode());
        assertEquals(InventoryConstants.MESSAGE_200, response.getBody().getStatusMsg());
    }

    @Test
    public void testPlaceOrderNonExistentSku() {
        IInventoryService iInventoryService = mock(IInventoryService.class);
        InventoryController inventoryController = new InventoryController(iInventoryService);
        UpdateQuantityAFOrderDto updateQuantityAFOrderDto = new UpdateQuantityAFOrderDto();
        updateQuantityAFOrderDto.setSku("nonExistentSKU");
        updateQuantityAFOrderDto.setQuantity(10);

        when(iInventoryService.reduceStock(any(UpdateQuantityAFOrderDto.class), anyInt())).thenReturn(false);

        ResponseEntity<ResponseDto> response = inventoryController.placeOrder(updateQuantityAFOrderDto, 10);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(InventoryConstants.STATUS_500, response.getBody().getStatusCode());
        assertEquals(InventoryConstants.MESSAGE_500, response.getBody().getStatusMsg());
    }

}
