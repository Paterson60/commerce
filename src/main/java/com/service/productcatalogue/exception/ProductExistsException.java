package com.service.productcatalogue.exception;

/**
 * Handles or throws exception when there is Product not found
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductExistsException extends RuntimeException{

    public ProductExistsException(String message){
        super(message);
    }
}
