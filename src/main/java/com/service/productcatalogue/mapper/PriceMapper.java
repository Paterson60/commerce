package com.service.productcatalogue.mapper;

/**
 * Converts the PriceDto Dto layer to Price Entity layer and vice versa
 *
 */

import com.service.productcatalogue.dto.PriceDto;
import com.service.productcatalogue.entity.Price;

public class PriceMapper {

    public static PriceDto mapToPriceDto(Price price, PriceDto priceDto){
        priceDto.setAmount(price.getAmount());
        priceDto.setDiscount(priceDto.getDiscount());
        return priceDto;
    }

    public static Price mapToPrice(PriceDto priceDto, Price price){
        price.setAmount(priceDto.getAmount());
        price.setDiscount(price.getDiscount());
        return price;
    }
}
