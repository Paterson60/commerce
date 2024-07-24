package com.service.inventorycatalogue.controller;

/**
* Controller class
*
*/

import com.service.inventorycatalogue.constants.InventoryConstants;
import com.service.inventorycatalogue.dto.ErrorResponseDto;
import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.dto.ResponseDto;
import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;
import com.service.inventorycatalogue.service.IInventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD Rest APIs of Inventory Management Service",
        description = "CRUD Rest APIs in Inventory"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class InventoryController extends RuntimeException{

    private final IInventoryService iInventoryService;

    public InventoryController(IInventoryService iInventoryService) {
        this.iInventoryService = iInventoryService;
    }

    @Operation(
            summary = "Add Inventory Rest API",
            description = "Rest API to add a new Product in Product Catalogue Service"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status Product Added"
    )
    @PostMapping("/addquantity")
    public ResponseEntity<ResponseDto> addQuantity(@Valid @RequestBody InventoryDto inventoryDto){
        iInventoryService.addQuantity(inventoryDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(InventoryConstants.STATUS_201, InventoryConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Inventory Quantity Details Rest API",
            description = "Rest API to fetch Inventory Quantity Details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Ok"
    )
    @GetMapping("/fetchquantity")
    public ResponseEntity<InventoryDto> fetchQuantity(@RequestParam
                                                      @NotEmpty(message = "Sku cannot be empty")
                                                      String sku){
        InventoryDto inventoryDto = iInventoryService.fetchQuantity(sku);
        return ResponseEntity.status(HttpStatus.OK).body(inventoryDto);
    }

    @Operation(
            summary = "Update Inventory Details Rest API",
            description = "Rest API to update Inventory Details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponseDto.class
                            )
                    )
            )
    })
    @PutMapping("/updatequantity")
    public ResponseEntity<ResponseDto> updateQuantity(@Valid @RequestBody InventoryDto inventoryDto){
        boolean isUpdated = iInventoryService.updateQuantity(inventoryDto);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(InventoryConstants.STATUS_200,InventoryConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(InventoryConstants.STATUS_500, InventoryConstants.MESSAGE_500));
        }
    }

    @Operation(
            summary = "Delete Inventory Rest API",
            description = "Rest API to Delete a Inventory"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"
            )
    })
    @DeleteMapping("/deletequantity")
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

    @Operation(
            summary = "Reduce Quantity Inventory Rest API",
            description = "Rest API to to reduce the number of Quantity in number when order placed"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"
            )
    })
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
