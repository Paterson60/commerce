package com.service.inventorycatalogue.exception;

/**
 * Handles or throws exception on duplicate Inventory
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SkuExistsException extends RuntimeException{

    public SkuExistsException(String message){
        super(message);
    }
}
