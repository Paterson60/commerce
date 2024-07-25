package com.service.productcatalogue.controller;

/**
 * Controller class to get details from Product and Inventory
 *
 */

import com.service.productcatalogue.dto.ProductInventoryDto;
import com.service.productcatalogue.service.IProductInventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(
        name = "Rest APIs For Product, Catalogue In Product Catalogue Service",
        description = "Rest API to fetch Product, Inventory details"
)
//@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
//@AllArgsConstructor
@Validated
public class ProductInventoryController {

    private final IProductInventoryService iProductInventoryService;

    public ProductInventoryController(IProductInventoryService iProductInventoryService){
        this.iProductInventoryService = iProductInventoryService;
    }

    @Operation(
            summary = "Fetch Product, Inventory Details Rest API",
            description = "Rest API to fetch Product, Inventory Details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Ok"
    )
    @GetMapping("/fetchproductinventory")
    public ResponseEntity<ProductInventoryDto> fetchProductInventoryDetails(@RequestParam
                                                                            @NotEmpty(message = "SKU cannot be empty")
                                                                            String sku){
        ProductInventoryDto productInventoryDto= iProductInventoryService.fetchProductInventoryDetails(sku);
        return ResponseEntity.status(HttpStatus.OK).body(productInventoryDto);
    }
}
