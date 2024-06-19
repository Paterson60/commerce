package com.service.inventorycatalogue.controller;

import com.service.inventorycatalogue.constants.InventoryConstants;
import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.dto.ResponseDto;
import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;
import com.service.inventorycatalogue.service.IInventoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class InventoryController {

    private IInventoryService iInventoryService;

    @PostMapping("/addQuantity")
    public ResponseEntity<ResponseDto> addQuantity(@Valid @RequestBody InventoryDto inventoryDto){
        iInventoryService.addQuantity(inventoryDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(InventoryConstants.STATUS_201, InventoryConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<InventoryDto> fetchQuantity(@RequestParam
                                                      @NotEmpty(message = "Sku cannot be empty")
                                                      String sku){
        InventoryDto inventoryDto = iInventoryService.fetchQuantity(sku);
        return ResponseEntity.status(HttpStatus.OK).body(inventoryDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateQuantity(@Valid @RequestBody InventoryDto inventoryDto){
        boolean isUpdated = iInventoryService.updateQuantity(inventoryDto);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(InventoryConstants.STATUS_200,InventoryConstants.MESSAGE_201));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(InventoryConstants.STATUS_500, InventoryConstants.MESSAGE_500));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteQuantity(@RequestParam
                                                          @NotEmpty(message = "Sku cannot be empty")
                                                          String sku){
        boolean isDeleted = iInventoryService.deleteQuantity(sku);
        if (isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(InventoryConstants.STATUS_200, InventoryConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(InventoryConstants.STATUS_417, InventoryConstants.MESSAGE_417_DELETE));
        }
    }

    @PutMapping("/order")
    public ResponseEntity<ResponseDto> placeOrder(@Valid @RequestBody UpdateQuantityAFOrderDto updateQuantityAFOrderDto, @RequestParam int quantity){
        boolean orderPlaced = iInventoryService.reduceStock(updateQuantityAFOrderDto, quantity);
        if(orderPlaced){
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(InventoryConstants.STATUS_200, InventoryConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(InventoryConstants.STATUS_500, InventoryConstants.MESSAGE_500));
        }
    }
}
